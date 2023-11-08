package com.pscoding.tasktrek.domain.usecase

import com.pscoding.tasktrek.domain.model.Task
import com.pscoding.tasktrek.domain.TaskTrekRepository

class GetTaskById(
    private val repository: TaskTrekRepository
) {
    suspend operator fun invoke(taskId: Int): Task? {
        return repository.getTaskById(taskId = taskId)
    }
}