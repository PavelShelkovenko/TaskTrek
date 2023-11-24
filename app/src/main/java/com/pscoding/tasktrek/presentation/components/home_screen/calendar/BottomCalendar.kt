package com.pscoding.tasktrek.presentation.components.home_screen.calendar


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.header.MonthState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import io.github.boguszpawlowski.composecalendar.selection.SelectionState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale


@Composable
fun BottomCalendar(
    modifier: Modifier = Modifier,
) {
    SelectableCalendar(
        modifier = modifier
            .fillMaxWidth(0.9f),
        //.animateContentSize(),
        dayContent = { dayState -> Day(dayState) },
        daysOfWeekHeader = { dayOfWeeks -> DaysOfWeekHeader(daysOfWeek = dayOfWeeks) },
        monthHeader = { monthState -> MonthHeader(monthState = monthState) }
    )
}

@Composable
fun MonthHeader(
    monthState: MonthState,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Calendar",
            color = MaterialTheme.colorScheme.background,
            style = MaterialTheme.typography.displayMedium
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.testTag("MonthLabel"),
            text = monthState.currentMonth.month
                .getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault())
                .lowercase()
                .replaceFirstChar { it.titlecase() },
            style = MaterialTheme.typography.displayMedium,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = monthState.currentMonth.year.toString(),
            style = MaterialTheme.typography.displayMedium
        )
    }
}

@Composable
fun DaysOfWeekHeader(
    daysOfWeek: List<DayOfWeek>,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        daysOfWeek.forEach { dayOfWeek ->
            Text(
                textAlign = TextAlign.Center,
                text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                modifier = modifier
                    .weight(1f)
                    .wrapContentHeight()
            )
        }
    }
}

@Composable
fun Day(
    state: DayState<DynamicSelectionState>,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit = {},
) {
    val date = state.date
    val selectionState = state.selectionState

    val isSelected = selectionState.isDateSelected(date)

    if (isSelected) {
        Box(
            modifier = modifier
                .height(36.dp)
                .width(36.dp)
                .clip(CircleShape)
                .clickable {
                    onClick(date)
                    selectionState.onDateSelected(date)
                }
                .background(MaterialTheme.colorScheme.onSecondary),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = date.dayOfMonth.toString(),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.displaySmall
            )
        }
    } else {
        Box(
            modifier = modifier
                .height(36.dp)
                .width(36.dp)
                .clickable {
                    onClick(date)
                    selectionState.onDateSelected(date)
                },
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = date.dayOfMonth.toString(),
                color = when {
                    state.isCurrentDay -> Color.Red
                    state.isFromCurrentMonth -> MaterialTheme.colorScheme.background
                    else -> MaterialTheme.colorScheme.onTertiary
                },
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomCalendarPreview() {
    TaskTrekTheme {
        BottomCalendar(modifier = Modifier.fillMaxWidth())
    }
}
