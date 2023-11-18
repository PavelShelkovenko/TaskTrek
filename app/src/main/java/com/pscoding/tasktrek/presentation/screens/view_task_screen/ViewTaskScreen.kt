package com.pscoding.tasktrek.presentation.screens.view_task_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme


@Composable
fun ViewTaskScreen() {
    Text(text = "ViewTaskScreen")
}

@Preview
@Composable
fun PreviewViewTaskScreen() {
    TaskTrekTheme {
        ViewTaskScreen()
    }
}