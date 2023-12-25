package com.pscoding.tasktrek.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pscoding.tasktrek.R
import com.pscoding.tasktrek.presentation.components.home_screen.TaskTrekActivity
import com.pscoding.tasktrek.presentation.components.home_screen.calendar.BottomCalendar
import com.pscoding.tasktrek.presentation.components.home_screen.header.HomeHeader
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
                .fillMaxHeight(0.27f)
                .clip(RoundedCornerShape(28.dp))
                .background(MaterialTheme.colorScheme.onBackground),
        ) {
            Column(
                modifier = Modifier.padding(top = 18.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 18.dp, start = 18.dp)
                        .height(32.dp)
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = { navigateToNewTaskScreen() },
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Add,
                            tint = MaterialTheme.colorScheme.onSecondary,
                            modifier = Modifier.fillMaxSize(),
                            contentDescription = null
                        )
                    }
                }
                HomeHeader(
                    userImage = state.userImage,
                    userName = state.userName ?: stringResource(id = R.string.default_name),
                    userStatus = state.userStatus ?: stringResource(id = R.string.default_status),
                    onUserImageChanged = { newUserImage ->
                        viewModel.onEvent(
                            HomeScreenEvent.UserImageChanged(
                                newUserImage = newUserImage
                            )
                        )
                    },
                    onUserNameChanged = { newUserName ->
                        viewModel.onEvent(
                            HomeScreenEvent.UserNameChanged(
                                newUserName = newUserName
                            )
                        )
                    },
                    onUserStatusChanged = { newUserStatus ->
                        viewModel.onEvent(
                            HomeScreenEvent.UserStatusChanged(
                                newUserStatus = newUserStatus
                            )
                        )
                    },
                )
            }
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
                    text = stringResource(id = R.string.my_tasks),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.displayMedium
                )
                TaskTrekActivity(
                    name = stringResource(id = R.string.to_do),
                    imageResId = R.drawable.ic_clock,
                    currentTasksCount = state.toDoTasksCount,
                    onClick = { navigateToViewTaskScreen() }
                )
                TaskTrekActivity(
                    name = stringResource(id = R.string.in_progress),
                    imageResId = R.drawable.ic_paperplane,
                    currentTasksCount = state.inProgressTasksCount,
                    onClick = { navigateToViewTaskScreen() }
                )
                TaskTrekActivity(
                    name = stringResource(id = R.string.done),
                    imageResId = R.drawable.ic_ok,
                    currentTasksCount = state.doneTasksCount,
                    onClick = { navigateToViewTaskScreen() }
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
            navigateToNewTaskScreen = {},
            navigateToViewTaskScreen = {}
        )
    }
}