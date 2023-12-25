package com.pscoding.tasktrek.presentation.components.new_task_screen.category

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme


@Composable
fun SingleCategory(
    categoryName: String,
    deleteCategory: (String) -> Unit,
    modifier: Modifier = Modifier,
) {

    var isClicked by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .animateContentSize()
            .clickable { isClicked = !isClicked }
    ) {
        if (isClicked) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = categoryName,
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Filled.Delete,
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.clickable { deleteCategory(categoryName) },
                    contentDescription = null
                )
                Spacer(Modifier.width(4.dp))
            }
        } else {
            Text(
                text = categoryName,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewSingleCategory() {
    TaskTrekTheme {
        SingleCategory(
            categoryName = "School project",
            {}
        )
    }
}