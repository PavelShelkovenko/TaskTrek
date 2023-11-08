package com.pscoding.tasktrek.domain.usecase

import com.pscoding.tasktrek.domain.model.Task
import com.pscoding.tasktrek.domain.TaskTrekRepository
import kotlinx.coroutines.flow.Flow

class GetAllTasks(
    private val repository: TaskTrekRepository
) {
    operator fun invoke(): Flow<List<Task>> {
        return repository.getAllTasks()
    }
}
