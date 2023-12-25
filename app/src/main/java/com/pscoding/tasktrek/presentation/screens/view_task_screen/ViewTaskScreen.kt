package com.pscoding.tasktrek.presentation.screens.view_task_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme


@Composable
fun ViewTaskScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "IN DEVELOPMENT",
            color = Color.White
        )
    }

}

@Preview
@Composable
fun PreviewViewTaskScreen() {
    TaskTrekTheme {
        ViewTaskScreen()
    }
}