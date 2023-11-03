package com.pscoding.tasktrek.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.presentation.components.new_task_screen.NewTaskContent
import com.pscoding.tasktrek.presentation.components.new_task_screen.NewTaskHeader
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme

@Composable
fun NewTaskScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(8.dp)) {
        NewTaskHeader(
            modifier = Modifier
                .padding(start = 28.dp)
                .weight(0.3f),
            openMenu = {}
        )
        Spacer(modifier = Modifier.height(12.dp))
        NewTaskContent(
            modifier = Modifier
                .weight(0.64f)
        )
    }

}

@Preview
@Composable
fun PreviewNewTaskScreen() {
    TaskTrekTheme {
        NewTaskScreen()
    }
}