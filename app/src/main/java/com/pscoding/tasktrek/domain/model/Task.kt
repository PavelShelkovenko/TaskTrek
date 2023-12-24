package com.pscoding.tasktrek.domain.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.UUID


data class Task(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val status: TaskStatus = TaskStatus.TODO,
    val date: Long = LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli(),
    val startingTime: Long = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC),
    val remindStatus: Boolean = false,
    val category: List<String> = emptyList(),
)

enum class TaskStatus {
    TODO, INPROGRESS, DONE
}

class InvalidTaskException(message: String) : Exception(message)