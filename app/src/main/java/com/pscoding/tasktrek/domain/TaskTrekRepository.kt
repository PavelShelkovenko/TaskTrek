package com.pscoding.tasktrek.domain

import com.pscoding.tasktrek.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskTrekRepository {

    suspend fun addTask(task: Task)

    suspend fun deleteTask(task: Task)

    suspend fun editTask(task: Task)

    suspend fun getTaskById(taskId: String): Task

    suspend fun getLastAddedTask(): Task
    fun getAllTasks(): Flow<List<Task>>

}