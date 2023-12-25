package com.pscoding.tasktrek.presentation.components.new_task_screen.category

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.pscoding.tasktrek.R
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme

@Composable
fun NewTaskCategory(
    modifier: Modifier = Modifier,
    categories: List<String>,
    addCategory: (String) -> Unit,
    deleteCategory: (String) -> Unit
) {
    val openDialog = remember {
        mutableStateOf(false)
    }

    var dialogText by remember {
        mutableStateOf("")
    }

    if (openDialog.value) {
        Dialog(
            onDismissRequest = {
                openDialog.value = false
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            AddCategoryDialog(
                dialogText = dialogText,
                onDialogTextChange = {
                    dialogText = it
                },
                addCategory = {
                    addCategory(it)
                    openDialog.value = false
                    dialogText = ""
                }
            )
        }
    }

    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.category),
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onTertiary,
        )
        Spacer(modifier = Modifier.height(12.dp))

        CategoryList(
            horizontalSpacing = 60,
            verticalSpacing = 60
        ) {
            for (category in categories) {
                SingleCategory(
                    categoryName = category,
                    deleteCategory = deleteCategory
                )
            }
            if (categories.size < 6) {
                AddCategoryButton(
                    onButtonClick = { openDialog.value = true }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewNewTaskCategory() {
    TaskTrekTheme {
        val listOfCategories = mutableListOf(
            "Weekend", "School Project", "Meeting"
        )
        NewTaskCategory(
            categories = listOfCategories,
            addCategory = {},
            deleteCategory = {}
        )
    }
}
