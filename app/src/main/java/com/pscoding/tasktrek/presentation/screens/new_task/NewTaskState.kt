package com.pscoding.tasktrek.presentation.screens.new_task

import java.time.LocalDate
import java.time.ZoneOffset
import java.util.Calendar

data class NewTaskState(
    val name: String = "",
    val date: Long = LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli(),
    val time: Long = Calendar.getInstance().time.toInstant().toEpochMilli(),
    val remindStatus: Boolean = false,
    val category: List<String> = emptyList()
)
