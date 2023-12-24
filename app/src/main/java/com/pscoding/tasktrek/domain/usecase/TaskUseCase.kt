package com.pscoding.tasktrek.domain.usecase

data class TaskUseCases(
    val getTasks: GetAllTasks,
    val deleteTask: DeleteTask,
    val editTask: EditTask,
    val addTask: AddTask,
    val getLastAddedTask: GetLastAddedTask,
    val getTaskById: GetTaskById
)