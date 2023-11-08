package com.pscoding.tasktrek.domain.usecase

import com.pscoding.tasktrek.domain.model.InvalidTaskException
import com.pscoding.tasktrek.domain.model.Task
import com.pscoding.tasktrek.domain.TaskTrekRepository

class AddTask(
    private val repository: TaskTrekRepository
) {
    @Throws(InvalidTaskException::class)
    suspend operator fun invoke(task: Task) {
        if(task.title.isBlank()) {
            throw InvalidTaskException("The title of the note can't be empty.")
        }
        repository.addTask(task = task)
    }
}