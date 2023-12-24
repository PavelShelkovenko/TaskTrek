package com.pscoding.tasktrek.presentation.screens.new_task


sealed class NewTaskEvent {
    data class TitleChanged(val newTitle: String) : NewTaskEvent()
    data class RemindStatusChanged(val newStatus: Boolean) : NewTaskEvent()
    data class TimeChanged(val newTime: String) : NewTaskEvent()
    data class DateChanged(val newDate: String) : NewTaskEvent()
    data class CategoryAdded(val newCategory: String) : NewTaskEvent()
    data class CategoryDeleted(val deletedCategory: String) : NewTaskEvent()
    data object CreateTask : NewTaskEvent()
    data object DeleteTask : NewTaskEvent()
}