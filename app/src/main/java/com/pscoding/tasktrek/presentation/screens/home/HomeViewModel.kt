package com.pscoding.tasktrek.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pscoding.tasktrek.domain.model.TaskStatus
import com.pscoding.tasktrek.domain.usecase.GetAllTasks
import com.pscoding.tasktrek.presentation.FileManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeViewModel(
    getAllTasks: GetAllTasks,
    private val fileManager: FileManager
) : ViewModel() {

    var state = MutableStateFlow(HomeScreenState())
        private set

    private val taskFlow = getAllTasks().map { allTasks ->
        allTasks.groupBy { task ->
            task.status
        }.mapValues {
            it.value.size
        }
    }

    init {
        viewModelScope.launch {
            taskFlow.collect { tasksMap ->
                state.update {
                    it.copy(
                        toDoTasksCount = tasksMap[TaskStatus.TODO] ?: 0,
                        inProgressTasksCount = tasksMap[TaskStatus.INPROGRESS] ?: 0,
                        doneTasksCount = tasksMap[TaskStatus.DONE] ?: 0,
                    )
                }
            }
        }
        loadUserInfo()
    }

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.UserImageChanged -> {
                event.newUserImage?.let { saveUserImage(it) }
            }

            is HomeScreenEvent.UserNameChanged -> {
                saveUserName(event.newUserName)
            }

            is HomeScreenEvent.UserStatusChanged -> {
                saveUserStatus(event.newUserStatus)
            }
        }
    }

    private fun updateUserImage() {
        viewModelScope.launch {
            val currentUserImage = fileManager.getUserImage(viewModelScope)
            state.update {
                it.copy(
                    userImage = currentUserImage
                )
            }
        }
    }

    private fun saveUserImage(newUserImage: ByteArray) {
        viewModelScope.launch {
            fileManager.saveUserImage(newUserImage = newUserImage)
            updateUserImage()
        }
    }

    private fun updateUserName() {
        viewModelScope.launch {
            val currentUserName = fileManager.getUserName(viewModelScope)
            state.update {
                it.copy(
                    userName = currentUserName
                )
            }
        }
    }

    private fun saveUserName(newUserName: String) {
        viewModelScope.launch {
            fileManager.saveUserName(newUserName = newUserName)
            updateUserName()
        }
    }

    private fun updateUserStatus() {
        viewModelScope.launch {
            val currentUserStatus = fileManager.getUserStatus(viewModelScope)
            state.update {
                it.copy(
                    userStatus = currentUserStatus
                )
            }
        }
    }

    private fun saveUserStatus(newUserStatus: String) {
        viewModelScope.launch {
            fileManager.saveUserStatus(newUserStatus = newUserStatus)
            updateUserStatus()
        }
    }

    private fun loadUserInfo() {
        updateUserImage()
        updateUserName()
        updateUserStatus()
    }
}