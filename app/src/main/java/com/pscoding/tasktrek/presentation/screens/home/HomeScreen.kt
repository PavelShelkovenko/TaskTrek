package com.pscoding.tasktrek.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.R
import com.pscoding.tasktrek.presentation.components.home_screen.BottomCalendar
import com.pscoding.tasktrek.presentation.components.home_screen.HomeHeader
import com.pscoding.tasktrek.presentation.components.home_screen.TaskTrekActivity
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(
    navigateToNewTaskScreen: () -> Unit,
    navigateToViewTaskScreen: () -> Unit,
) {
    val viewModel = koinViewModel<HomeViewModel>()

    Column(
        modifier = Modifier.fillMaxSize().padding(12.dp)
    ) {
        HomeHeader(
            modifier = Modifier.weight(0.23f),
            userImage = R.drawable.ic_user_avatar_defalt,
            addNewTask = { navigateToNewTaskScreen() },
            changeImage = {}
        )

        Spacer(Modifier.height(4.dp))

        Column(
            modifier = Modifier.weight(0.25f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "My tasks",
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(start = 28.dp),
                style = MaterialTheme.typography.displayMedium
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

        Spacer(Modifier.height(4.dp))

        BottomCalendar(
            modifier = Modifier.weight(0.23f)
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    TaskTrekTheme {
        HomeScreen(
            navigateToNewTaskScreen ={},
            navigateToViewTaskScreen ={}
        )
    }
}