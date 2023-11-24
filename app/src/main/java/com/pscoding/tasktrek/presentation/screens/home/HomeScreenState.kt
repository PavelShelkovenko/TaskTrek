package com.pscoding.tasktrek.presentation.screens.home

data class HomeScreenState(
    val toDoTasksCount: Int = 0,
    val inProgressTasksCount: Int = 0,
    val doneTasksCount: Int = 0,
)