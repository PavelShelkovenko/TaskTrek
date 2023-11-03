package com.pscoding.tasktrek.presentation.components.new_task_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.R
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateChooser(
    modifier: Modifier = Modifier
) {
    val openDialog = remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    if (openDialog.value) {
        val confirmEnabled = remember {
            derivedStateOf { datePickerState.selectedDateMillis != null }
        }
        DatePickerDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        //datePickerState.selectedDateMillis
                    },
                    enabled = confirmEnabled.value
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(
                state = datePickerState,
                colors = DatePickerDefaults.colors(
                    selectedDayContentColor = MaterialTheme.colorScheme.onSecondary,
                    selectedYearContentColor = MaterialTheme.colorScheme.onSecondary,
                )
            )
        }
    }

    Column(modifier = modifier) {
        Text(
            text = "Date",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onTertiary,
            modifier = Modifier.clickable { openDialog.value = true }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { openDialog.value = true }
        ) {
            Text(
                text = "Wednesday 3, July",
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                    .padding(top = 14.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.ic_calendar),
                contentDescription = null
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onSecondary)
                .height(1.dp)
        ) {

        }
    }
}

@Preview
@Composable
fun PreviewDateChooser() {
    TaskTrekTheme {
        DateChooser()
    }
}