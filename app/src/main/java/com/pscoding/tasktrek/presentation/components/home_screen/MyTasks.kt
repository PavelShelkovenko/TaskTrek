package com.pscoding.tasktrek.presentation.components.home_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme

@Composable
fun MyTasks(
    modifier: Modifier = Modifier,
    onToDoClick: () -> Unit,
    onInProgressClick: () -> Unit,
    onDoneClick: () -> Unit
) {

}

@Preview
@Composable
fun PreviewMainContent() {
    TaskTrekTheme {
        MyTasks(
            modifier = Modifier,
            {}, {}, {}
        )
    }
}
