package com.pscoding.tasktrek.presentation.components.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.R
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme

@Composable
fun TaskTrekActivity(
    name: String,
    modifier: Modifier = Modifier,
    imageResId: Int,
    currentTasksCount: Int,
    completedTasksCount: Int,
    onClick: (String) -> Unit
) {
    Row(
        modifier = modifier
            .wrapContentWidth()
            .clickable { onClick(name) },
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(MaterialTheme.colorScheme.onBackground),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(42.dp),
                painter = painterResource(id = imageResId),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = name,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = "$currentTasksCount tasks now  /  $completedTasksCount completed",
                color = MaterialTheme.colorScheme.onTertiary,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun TaskTrekActivityPreview() {
    TaskTrekTheme {
        TaskTrekActivity(
            name = "To do",
            imageResId = R.drawable.ic_clock,
            currentTasksCount = 21,
            completedTasksCount = 12,
            onClick = {}
        )
    }
}