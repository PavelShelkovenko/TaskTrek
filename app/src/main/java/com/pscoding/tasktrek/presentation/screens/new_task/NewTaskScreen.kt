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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.presentation.components.new_task_screen.DateChooser
import com.pscoding.tasktrek.presentation.components.new_task_screen.NewTaskCreateButton
import com.pscoding.tasktrek.presentation.components.new_task_screen.NewTaskHeader
import com.pscoding.tasktrek.presentation.components.new_task_screen.Reminder
import com.pscoding.tasktrek.presentation.components.new_task_screen.TimeChooser
import com.pscoding.tasktrek.presentation.components.new_task_screen.category.NewTaskCategory
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewTaskScreen(
    modifier: Modifier = Modifier
) {

    val viewModel = koinViewModel<NewTaskViewModel>()
    val state by viewModel.state.collectAsState()

    Column(modifier = modifier.fillMaxSize().padding(8.dp)) {
        NewTaskHeader(
            modifier = Modifier
                .padding(start = 28.dp)
                .weight(0.3f),
            title = state.title,
            onTitleChanged = { newTitle ->
                viewModel.onEvent(NewTaskEvent.TitleChanged(newTitle))
            },
            openMenu = {}
        )
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = modifier.fillMaxSize()
                .weight(0.64f)
                .clip(RoundedCornerShape(32.dp))
                .background(MaterialTheme.colorScheme.onBackground)
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxSize()
            ) {
                item {
                    DateChooser(
                        selectedDate = state.date,
                        onSelectedDateChanged = { newDate ->
                            viewModel.onEvent(
                                NewTaskEvent.DateChanged(newDate = newDate)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }

                item {
                    TimeChooser(
                        selectedTime = state.time,
                        onSelectedTimeChanged = { newTime ->
                            viewModel.onEvent(
                                NewTaskEvent.TimeChanged(newTime = newTime)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }

                item {
                    Reminder(
                        remindStatus = state.remindStatus,
                        onRemindStatusChanged = { newStatus ->
                            viewModel.onEvent(
                                NewTaskEvent.RemindStatusChanged(newStatus = newStatus)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }

                item {
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
                }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        NewTaskCreateButton {
                            viewModel.onEvent(NewTaskEvent.CreateTask)
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
        NewTaskScreen()
    }
}