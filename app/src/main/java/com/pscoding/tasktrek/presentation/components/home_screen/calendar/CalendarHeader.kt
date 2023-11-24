package com.pscoding.tasktrek.presentation.components.home_screen.calendar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme


@Composable
fun CalendarHeader(
    currentMonth: String,
    currentYear: String
) {
    Row {
        Text(
            text = "Calendar",
            color = MaterialTheme.colorScheme.background,
            style = MaterialTheme.typography.displayMedium
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "$currentYear $currentMonth",
            color = MaterialTheme.colorScheme.background,
            style = MaterialTheme.typography.displayMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCalendarHeader() {
    TaskTrekTheme {
        CalendarHeader(
            currentMonth = "November",
            currentYear = "2023"
        )
    }
}