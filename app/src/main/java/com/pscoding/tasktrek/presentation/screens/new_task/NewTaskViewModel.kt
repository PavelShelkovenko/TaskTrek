package com.pscoding.tasktrek.presentation.screens.new_task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
                        name = event.newName
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

            is NewTaskEvent.CategoryChanged -> {
                state.update {
                    val newList = state.value.category.toMutableList()
                    newList.add(event.newCategory)
                    it.copy(
                        category = newList
                    )
                }
            }

            is NewTaskEvent.CreateTask -> {
                viewModelScope.launch {
                    addTask(
                        task = Task(
                            title = state.value.name,
                            date = state.value.date,
                            startingTime = state.value.time,
                            remindStatus = state.value.remindStatus,
                            category = state.value.category
                        )
                    )
                }
            }
        }
    }

}