package com.pscoding.tasktrek.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pscoding.tasktrek.domain.model.TaskStatus


@Entity(tableName = "task_trek")
data class TaskDbModel(
    @PrimaryKey
    val id: String,
    val title: String,
    val status: TaskStatus,
    val date: Long,
    val startingTime: Long,
    val remindStatus: Boolean,
    val category: List<String>,
)
