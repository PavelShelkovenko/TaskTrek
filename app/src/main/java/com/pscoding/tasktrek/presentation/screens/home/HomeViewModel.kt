package com.pscoding.tasktrek.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.pscoding.tasktrek.domain.usecase.TaskUseCases


class HomeViewModel(
    val taskUseCases: TaskUseCases
): ViewModel() {

}