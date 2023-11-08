package com.pscoding.tasktrek.domain

import com.pscoding.tasktrek.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskTrekRepository {

    suspend fun addTask(task: Task)

    suspend fun deleteTask(task: Task)

    suspend fun editTask(task: Task)

    suspend fun getTaskById(taskId: Int): Task

    fun getAllTasks(): Flow<List<Task>>

}