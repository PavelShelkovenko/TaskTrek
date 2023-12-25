package com.pscoding.tasktrek.presentation.components.home_screen.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import java.time.LocalDate

@Composable
fun Day(
    state: DayState<DynamicSelectionState>,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit = {},
) {
    val date = state.date
    val selectionState = state.selectionState

    val isSelected = selectionState.isDateSelected(date)

    Box(
        modifier = modifier
            .height(36.dp)
            .width(36.dp)
            .clip(CircleShape)
            .conditional(
                condition = isSelected,
                ifTrue = {
                    this.background(MaterialTheme.colorScheme.onSecondary)
                }
            )
            .clickable {
                onClick(date)
                selectionState.onDateSelected(date)
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = date.dayOfMonth.toString(),
            color = if (isSelected) MaterialTheme.colorScheme.onPrimary else {
                when {
                    state.isCurrentDay -> Color.Red
                    state.isFromCurrentMonth -> MaterialTheme.colorScheme.background
                    else -> MaterialTheme.colorScheme.onTertiary
                }
            },
            style = MaterialTheme.typography.displaySmall
        )
    }
}

inline fun Modifier.conditional(
    condition: Boolean,
    ifTrue: Modifier.() -> Modifier,
    ifFalse: Modifier.() -> Modifier = { this },
): Modifier = if (condition) {
    then(ifTrue(Modifier))
} else {
    then(ifFalse(Modifier))
}