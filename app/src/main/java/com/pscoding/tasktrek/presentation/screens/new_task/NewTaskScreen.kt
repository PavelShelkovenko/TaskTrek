package com.pscoding.tasktrek.presentation.screens.new_task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pscoding.tasktrek.R
import com.pscoding.tasktrek.presentation.components.new_task_screen.DateChooser
import com.pscoding.tasktrek.presentation.components.new_task_screen.NewTaskCreateButton
import com.pscoding.tasktrek.presentation.components.new_task_screen.NewTaskHeader
import com.pscoding.tasktrek.presentation.components.new_task_screen.Reminder
import com.pscoding.tasktrek.presentation.components.new_task_screen.TimeChooser
import com.pscoding.tasktrek.presentation.components.new_task_screen.category.NewTaskCategory
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewTaskScreen(
    modifier: Modifier = Modifier,
    navigateBackToHomeScreen: () -> Unit
) {

    val viewModel = koinViewModel<NewTaskViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }


    val onShowSnackbar: (String) -> Unit = { title ->
        coroutineScope.launch {
            val result = snackbarHostState
                .showSnackbar(
                    message = context.getString(R.string.new_task_snackbar_message, title),
                    actionLabel = context.getString(R.string.undo),
                    duration = SnackbarDuration.Short
                )
            when (result) {
                SnackbarResult.ActionPerformed -> {
                    viewModel.onEvent(NewTaskEvent.DeleteTask)
                }

                SnackbarResult.Dismissed -> {
                    /* Handle snackbar dismissed */
                }
            }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) {
                Snackbar(
                    snackbarData = it,
                    shape = RoundedCornerShape(10.dp),
                    containerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.onBackground,
                    actionColor = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(8.dp)
        ) {
            NewTaskHeader(
                modifier = Modifier
                    .padding(start = 28.dp)
                    .weight(0.3f),
                title = state.title,
                onTitleChanged = { newTitle ->
                    viewModel.onEvent(NewTaskEvent.TitleChanged(newTitle))
                },
                navigateBackToHomeScreen = { navigateBackToHomeScreen() }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .weight(0.64f)
                    .clip(RoundedCornerShape(32.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
                    .verticalScroll(scrollState)
            ) {
                Column(
                    modifier = Modifier
                        .padding(32.dp)
                        .fillMaxSize()
                ) {
                    DateChooser(
                        selectedDate = state.date,
                        onSelectedDateChanged = { newDate ->
                            viewModel.onEvent(
                                NewTaskEvent.DateChanged(newDate = newDate)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    TimeChooser(
                        selectedTime = state.time,
                        onSelectedTimeChanged = { newTime ->
                            viewModel.onEvent(
                                NewTaskEvent.TimeChanged(newTime = newTime)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    Reminder(
                        remindStatus = state.remindStatus,
                        onRemindStatusChanged = { newStatus ->
                            viewModel.onEvent(
                                NewTaskEvent.RemindStatusChanged(newStatus = newStatus)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    NewTaskCategory(
                        modifier = Modifier.fillMaxWidth(),
                        categories = state.category,
                        addCategory = { newCategory ->
                            viewModel.onEvent(
                                NewTaskEvent.CategoryAdded(newCategory = newCategory)
                            )
                        },
                        deleteCategory = { deletedCategory ->
                            viewModel.onEvent(
                                NewTaskEvent.CategoryDeleted(deletedCategory = deletedCategory)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(32.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        NewTaskCreateButton {
                            viewModel.onEvent(NewTaskEvent.CreateTask)
                            onShowSnackbar(state.title)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewNewTaskScreen() {
    TaskTrekTheme {
        NewTaskScreen(
            navigateBackToHomeScreen = {}
        )
    }
}