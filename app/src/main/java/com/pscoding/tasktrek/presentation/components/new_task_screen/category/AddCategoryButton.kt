package com.pscoding.tasktrek.presentation.components.new_task_screen.category

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme

@Composable
fun AddCategoryButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .clickable { onButtonClick() }
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            modifier = Modifier.size(38.dp).padding(8.dp),
            tint = MaterialTheme.colorScheme.onBackground,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun PreviewAddCategoryButton(

) {
    TaskTrekTheme {
        AddCategoryButton(
            onButtonClick = {}
        )
    }
}