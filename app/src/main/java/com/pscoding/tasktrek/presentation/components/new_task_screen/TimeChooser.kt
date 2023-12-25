package com.pscoding.tasktrek.presentation.components.new_task_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.pscoding.tasktrek.R
import com.pscoding.tasktrek.domain.formatTimeToString
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeChooser(
    modifier: Modifier = Modifier,
    selectedTime: String,
    onSelectedTimeChanged: (String) -> Unit
) {
    var showTimePicker by remember { mutableStateOf(false) }
    val state = rememberTimePickerState()

    if (showTimePicker) {
        TimePickerDialog(
            onCancel = { showTimePicker = false },
            onConfirm = {
                val cal = Calendar.getInstance()
                cal.set(Calendar.HOUR_OF_DAY, state.hour)
                cal.set(Calendar.MINUTE, state.minute)
                cal.isLenient = false
                onSelectedTimeChanged(formatTimeToString(cal.timeInMillis))
                showTimePicker = false
            },
        ) {
            TimePicker(
                state = state,
                colors = TimePickerDefaults.colors(
                    selectorColor = MaterialTheme.colorScheme.onSecondary,
                    periodSelectorSelectedContainerColor = MaterialTheme.colorScheme.onPrimary,
                    periodSelectorSelectedContentColor = MaterialTheme.colorScheme.onSecondary,
                    periodSelectorUnselectedContainerColor = MaterialTheme.colorScheme.background,
                    periodSelectorUnselectedContentColor = MaterialTheme.colorScheme.onBackground,
                    timeSelectorSelectedContainerColor = MaterialTheme.colorScheme.onPrimary,
                    timeSelectorSelectedContentColor = MaterialTheme.colorScheme.onSecondary,
                    timeSelectorUnselectedContainerColor = MaterialTheme.colorScheme.background,
                    timeSelectorUnselectedContentColor = MaterialTheme.colorScheme.onBackground,
                    clockDialColor = MaterialTheme.colorScheme.onPrimary,
                    clockDialSelectedContentColor = MaterialTheme.colorScheme.onPrimary,
                    clockDialUnselectedContentColor = MaterialTheme.colorScheme.onSecondary,
                )
            )
        }
    }

    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.starting_time),
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onTertiary,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { showTimePicker = true }
        ) {
            Text(
                text = selectedTime,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                    .padding(top = 14.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.ic_clock),
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
fun PreviewTimeChooser() {
    TaskTrekTheme {
        TimeChooser(
            selectedTime = "",
            onSelectedTimeChanged = {}
        )
    }
}

@Composable
fun TimePickerDialog(
    title: String = stringResource(id = R.string.select_time),
    onCancel: () -> Unit,
    onConfirm: () -> Unit,
    toggle: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onCancel,
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            tonalElevation = 6.dp,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
                .background(
                    shape = MaterialTheme.shapes.extraLarge,
                    color = MaterialTheme.colorScheme.surface
                ),
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 20.dp),
                    text = title,
                    style = MaterialTheme.typography.displayLarge
                )
                content()
                Row(modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                ) {
                    toggle()
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(onClick = onCancel) {
                        Text(
                            text = stringResource(id = R.string.cancel),
                            style = MaterialTheme.typography.displayMedium
                        )
                    }
                    TextButton(onClick = onConfirm) {
                        Text(
                            text = stringResource(id = R.string.ok),
                            style = MaterialTheme.typography.displayMedium
                        )
                    }
                }
            }
        }
    }
}