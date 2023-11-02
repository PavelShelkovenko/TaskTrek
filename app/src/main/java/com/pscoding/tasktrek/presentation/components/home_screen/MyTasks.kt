package com.pscoding.tasktrek.presentation.components.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pscoding.tasktrek.R
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme
import com.pscoding.tasktrek.presentation.theme.comfortaaFamily

@Composable
fun MyTasks(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(start = 12.dp, top = 8.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "My tasks",
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(start = 28.dp),
            fontSize = 22.sp,
            fontFamily = comfortaaFamily,
            fontWeight = FontWeight.ExtraBold
        )
        TaskTrekActivity(
            modifier = Modifier.padding(start = 28.dp, top = 14.dp),
            name = "To do",
            imageResId = R.drawable.ic_clock,
            currentTasksCount = 21,
            completedTasksCount = 12,
            onClick = {}
        )
        TaskTrekActivity(
            modifier = Modifier.padding(start = 28.dp, top = 20.dp),
            name = "In progress",
            imageResId = R.drawable.ic_paperplane,
            currentTasksCount = 21,
            completedTasksCount = 12,
            onClick = {}
        )
        TaskTrekActivity(
            modifier = Modifier.padding(start = 28.dp, top = 20.dp),
            name = "Done",
            imageResId = R.drawable.ic_ok,
            currentTasksCount = 21,
            completedTasksCount = 12,
            onClick = {}
        )
    }
}

@Preview
@Composable
fun PreviewMainContent() {
    TaskTrekTheme {
        MyTasks()
    }
}
