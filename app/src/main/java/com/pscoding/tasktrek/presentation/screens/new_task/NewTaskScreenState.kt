package com.pscoding.tasktrek.presentation.screens.new_task

import com.pscoding.tasktrek.domain.formatDateToString
import com.pscoding.tasktrek.domain.formatTimeToString
import java.time.LocalDate
import java.time.ZoneOffset
import java.util.Calendar

data class NewTaskScreenState(
    val title: String = "",
    val date: String = formatDateToString(
        LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli()
    ),
    val time: String = formatTimeToString(
        Calendar.getInstance().time.toInstant().toEpochMilli()
    ),
    val remindStatus: Boolean = false,
    val category: List<String> = emptyList()
)
