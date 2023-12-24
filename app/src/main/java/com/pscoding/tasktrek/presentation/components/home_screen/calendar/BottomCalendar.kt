package com.pscoding.tasktrek.presentation.components.home_screen.calendar


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme
import io.github.boguszpawlowski.composecalendar.SelectableCalendar


@Composable
fun BottomCalendar(
    modifier: Modifier = Modifier,
) {
    SelectableCalendar(
        modifier = modifier
            .fillMaxWidth(0.9f),
        dayContent = { dayState -> Day(dayState) },
        daysOfWeekHeader = { dayOfWeeks -> DaysOfWeekHeader(daysOfWeek = dayOfWeeks) },
        monthHeader = { monthState -> MonthHeader(monthState = monthState) }
    )
}

@Preview(showBackground = true)
@Composable
fun BottomCalendarPreview() {
    TaskTrekTheme {
        BottomCalendar(modifier = Modifier.fillMaxWidth())
    }
}
