package com.pscoding.tasktrek.domain.usecase

import com.pscoding.tasktrek.domain.TaskTrekRepository
import com.pscoding.tasktrek.domain.model.Task

class GetLastAddedTask(
    private val repository: TaskTrekRepository
) {
    suspend operator fun invoke(): Task {
        return repository.getLastAddedTask()
    }
}