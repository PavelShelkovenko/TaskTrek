package com.pscoding.tasktrek.presentation.components.new_task_screen.category

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme

@Composable
fun AddCategoryDialog(
    dialogText: String,
    onDialogTextChange: (String) -> Unit,
    addCategory: (String) -> Unit
) {

    val canAddCategory = dialogText.length < 20

    Box(
        modifier = Modifier
            .width(280.dp)
            .height(280.dp)
            .clip(RoundedCornerShape(42.dp))
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(0.05f))
            Text(
                text = "Add new category",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.weight(0.1f))
            OutlinedTextField(
                value = dialogText,
                onValueChange = {
                    onDialogTextChange(it)
                },
                textStyle = MaterialTheme.typography.displayMedium,
                label = {
                    Text("Category name")
                },
                isError = dialogText.length >= 20,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                    unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.background,
                    focusedContainerColor = MaterialTheme.colorScheme.background,
                    cursorColor = MaterialTheme.colorScheme.onPrimary
                ),
                maxLines = 1,
                shape = RoundedCornerShape(16.dp),
                supportingText = {
                    if (!canAddCategory) {
                        Text(text = "Too many characters")
                    }
                }
            )
            Spacer(modifier = Modifier.weight(0.05f))
            Button(
                onClick = {
                    if (canAddCategory) {
                        addCategory(dialogText)
                    }
                },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                shape = CutCornerShape(2.dp),
                border = BorderStroke(2.dp, MaterialTheme.colorScheme.onBackground),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    pressedElevation = 12.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            ) {
                Text(
                    text = "Add",
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewAddCategoryDialog() {
    TaskTrekTheme {
        AddCategoryDialog(
            dialogText = "hello there",
            onDialogTextChange = {},
            addCategory = {}
        )
    }
}