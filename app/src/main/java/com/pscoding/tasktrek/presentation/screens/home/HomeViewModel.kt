package com.pscoding.tasktrek.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pscoding.tasktrek.domain.model.TaskStatus
import com.pscoding.tasktrek.domain.usecase.GetAllTasks
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class HomeViewModel(
    private val getAllTasks: GetAllTasks
) : ViewModel() {


    var toDoTasksList = getAllTasks().map { listOfTasks ->
        listOfTasks.filter { task ->
            task.status == TaskStatus.TODO
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

    val state = getAllTasks().map {
        it.groupBy {
            it.status
        }.mapValues {
            it.value.size
        }
    }.map {
        HomeScreenState(
            toDoTasksCount = it[TaskStatus.TODO] ?: 0,
            inProgressTasksCount = it[TaskStatus.INPROGRESS] ?: 0,
            doneTasksCount = it[TaskStatus.DONE] ?: 0,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = HomeScreenState()
    )



    var inProgressTasksList = getAllTasks().map { listOfTasks ->
        listOfTasks.filter { task ->
            task.status == TaskStatus.INPROGRESS
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

    var doneTasksList = getAllTasks().map { listOfTasks ->
        listOfTasks.filter { task ->
            task.status == TaskStatus.DONE
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

}