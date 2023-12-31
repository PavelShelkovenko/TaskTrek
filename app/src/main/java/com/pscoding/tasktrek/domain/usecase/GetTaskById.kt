package com.pscoding.tasktrek.domain.usecase

import com.pscoding.tasktrek.domain.TaskTrekRepository
import com.pscoding.tasktrek.domain.model.Task

class GetTaskById(
    private val repository: TaskTrekRepository
) {
    suspend operator fun invoke(taskId: String): Task {
        return repository.getTaskById(taskId = taskId)
    }
}