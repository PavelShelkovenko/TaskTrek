package com.pscoding.tasktrek.presentation.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pscoding.tasktrek.R
import com.pscoding.tasktrek.presentation.components.home_screen.HomeHeader
import com.pscoding.tasktrek.presentation.components.home_screen.TaskTrekActivity
import com.pscoding.tasktrek.presentation.components.home_screen.calendar.BottomCalendar
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme
import org.koin.androidx.compose.koinViewModel



@Composable
fun HomeScreen(
    navigateToNewTaskScreen: () -> Unit,
    navigateToViewTaskScreen: () -> Unit,
) {
    val viewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 6.dp, end = 6.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f)
                .clip(RoundedCornerShape(28.dp))
                .background(MaterialTheme.colorScheme.onBackground)
        ) {
            HomeHeader(
                userImage = R.drawable.ic_user_avatar_defalt,
                addNewTask = { navigateToNewTaskScreen() },
                changeImage = {}
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight(0.45f)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 42.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "My tasks",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.displayMedium
                )
                TaskTrekActivity(
                    name = "To do",
                    imageResId = R.drawable.ic_clock,
                    currentTasksCount = state.toDoTasksCount,
                    onClick = {}
                )
                TaskTrekActivity(
                    name = "In progress",
                    imageResId = R.drawable.ic_paperplane,
                    currentTasksCount = state.inProgressTasksCount,
                    onClick = {}
                )
                TaskTrekActivity(
                    name = "Done",
                    imageResId = R.drawable.ic_ok,
                    currentTasksCount = state.doneTasksCount,
                    onClick = {}
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f)
                .clip(RoundedCornerShape(28.dp))
                .background(MaterialTheme.colorScheme.onBackground)
        ) {
            BottomCalendar(
                modifier = Modifier.padding(start = 28.dp, top = 24.dp)
            )
        }
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