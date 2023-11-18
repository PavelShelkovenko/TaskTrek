package com.pscoding.tasktrek.presentation.screens.new_task


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pscoding.tasktrek.domain.formatStringToDate
import com.pscoding.tasktrek.domain.formatStringToTime
import com.pscoding.tasktrek.domain.model.InvalidTaskException
import com.pscoding.tasktrek.domain.model.Task
import com.pscoding.tasktrek.domain.usecase.AddTask
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewTaskViewModel(
    private val addTask: AddTask
) : ViewModel() {

    var state = MutableStateFlow(NewTaskState())
        private set

    fun onEvent(event: NewTaskEvent) {
        when (event) {
            is NewTaskEvent.TitleChanged -> {
                state.update {
                    it.copy(
                        title = event.newTitle
                    )
                }
            }

            is NewTaskEvent.RemindStatusChanged -> {
                state.update {
                    it.copy(
                        remindStatus = event.newStatus
                    )
                }
            }

            is NewTaskEvent.TimeChanged -> {
                state.update {
                    it.copy(
                        time = event.newTime
                    )
                }
            }

            is NewTaskEvent.DateChanged -> {
                state.update {
                    it.copy(
                        date = event.newDate
                    )
                }
            }

            is NewTaskEvent.CategoryAdded -> {

                if (canAddCategory() && event.newCategory.trim().isNotEmpty()) {
                    state.update {
                        val newList = state.value.category.toMutableList()
                        newList.add(event.newCategory)
                        it.copy(
                            category = newList
                        )
                    }
                }
            }

            is NewTaskEvent.CategoryDeleted -> {
                state.update {
                    val newList = state.value.category.toMutableList()
                    newList.remove(event.deletedCategory)
                    it.copy(
                        category = newList
                    )
                }
            }

            is NewTaskEvent.CreateTask -> {
                createTask()
            }
        }
    }

    private fun canAddCategory(): Boolean {
        val categoryList = state.value.category
        return categoryList.size <= 5
    }

    private fun createTask() {
        viewModelScope.launch {
            try {
                addTask(
                    task = Task(
                        title = state.value.title,
                        date = formatStringToDate(state.value.date),        // Unhandled exception InvalidFormatException
                        startingTime = formatStringToTime(state.value.time),// Unhandled exception InvalidFormatException
                        remindStatus = state.value.remindStatus,
                        category = state.value.category
                    )
                )
            } catch (e: InvalidTaskException) {
                println(e.message)
            }
        }
    }
}