package com.pscoding.tasktrek.domain


import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Date
import java.util.Locale

fun formatTimeToString(time: Long): String {
    val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
    return formatter.format(time)
}

fun formatDateToString(timestamp: Long?): String {
    val date = timestamp?.let { Date(it) }
    val format = SimpleDateFormat("EEEE d, MMMM", Locale.getDefault())
    return format.format(date)
}