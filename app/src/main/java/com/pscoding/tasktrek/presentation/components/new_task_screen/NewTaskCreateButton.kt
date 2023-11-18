package com.pscoding.tasktrek.presentation.components.new_task_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme

@Composable
fun NewTaskCreateButton(
    modifier: Modifier = Modifier,
    createNewTask: () -> Unit
) {
    Box(modifier = modifier) {
        Button(
            onClick = { createNewTask() },
            shape = CutCornerShape(2.dp),
            border = BorderStroke(4.dp, MaterialTheme.colorScheme.background),
            elevation = ButtonDefaults.elevatedButtonElevation(
                pressedElevation = 30.dp
            )
        ) {
            Text(
                text = "Create",
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

@Preview
@Composable
fun PreviewNewTaskButton() {
    TaskTrekTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onBackground)
        )
        NewTaskCreateButton(
            createNewTask = {}
        )
    }
}