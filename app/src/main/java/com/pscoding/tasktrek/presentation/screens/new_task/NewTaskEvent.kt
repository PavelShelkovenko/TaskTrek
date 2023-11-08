package com.pscoding.tasktrek.presentation.screens.new_task

sealed class NewTaskEvent {
    data class TitleChanged(val newName: String): NewTaskEvent()
    data class RemindStatusChanged(val newStatus: Boolean): NewTaskEvent()
    data class TimeChanged(val newTime: Long): NewTaskEvent()
    data class DateChanged(val newDate: Long): NewTaskEvent()
    data class CategoryChanged(val newCategory: String): NewTaskEvent()
    data object CreateTask: NewTaskEvent()
}