package com.pscoding.tasktrek.domain.usecase

data class TaskUseCases(
    val getTasks: GetAllTasks,
    val deleteTask: DeleteTask,
    val editTask: EditTask,
    val addTask: AddTask,
    val getTaskById: GetTaskById
)