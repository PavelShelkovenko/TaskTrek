package com.pscoding.tasktrek.presentation.components.new_task_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme

@Composable
fun NewTaskCategory(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Category",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onTertiary,
            modifier = Modifier
        )
        Row {
            SingleCategory(
                modifier = Modifier.padding(top = 14.dp),
                categoryName = "+"
            )
            SingleCategory(
                modifier = Modifier.padding(start = 14.dp, top = 14.dp),
                categoryName = "School project"
            )
            SingleCategory(
                modifier = Modifier.padding(start = 14.dp, top = 14.dp),
                categoryName = "Workout"
            )
        }
        SingleCategory(
            modifier = Modifier.padding(top = 14.dp),
            categoryName = "School project"
        )
    }
}
@Preview
@Composable
fun PreviewNewTaskCategory() {
    TaskTrekTheme {
        NewTaskCategory()
    }
}