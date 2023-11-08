package com.pscoding.tasktrek.domain.usecase

import com.pscoding.tasktrek.domain.model.Task
import com.pscoding.tasktrek.domain.TaskTrekRepository

class DeleteTask(
    private val repository: TaskTrekRepository
) {
    suspend operator fun invoke(task: Task) {
        repository.deleteTask(task = task)
    }
}