package com.pscoding.tasktrek.domain


import java.text.SimpleDateFormat
import java.time.format.TextStyle
import java.util.Date
import java.util.Locale

fun formatTimeToString(time: Long): String {
    val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
    return formatter.format(time)
}

fun formatDateToString(timestamp: Long): String {
    val date = Date(timestamp)
    val format = SimpleDateFormat("EEEE d, MMMM", Locale.getDefault())
    val result = format.format(date)
    return result.lowercase().replaceFirstChar { it.titlecase() }
}

fun formatStringToTime(string: String): Long {
    val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
    return formatter.parse(string)?.time ?: throw
        InvalidFormatException("Can't format string $string")
}

fun formatStringToDate(string: String): Long {
    val format = SimpleDateFormat("EEEE d, MMMM", Locale.getDefault())
    return format.parse(string)?.time ?: throw
        InvalidFormatException("Can't format string $string")
}

class InvalidFormatException(message: String): Exception(message)