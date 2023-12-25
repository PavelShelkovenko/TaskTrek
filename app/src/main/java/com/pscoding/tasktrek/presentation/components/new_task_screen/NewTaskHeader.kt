package com.pscoding.tasktrek.presentation.components.new_task_screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.R
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme


@Composable
fun NewTaskHeader(
    modifier: Modifier = Modifier,
    title: String,
    onTitleChanged: (String) -> Unit,
    navigateBackToHomeScreen: () -> Unit
) {

    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { navigateBackToHomeScreen() }) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    contentDescription = null
                )
            }
        }
        Text(
            text = stringResource(id = R.string.create_new_task),
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(bottom = 4.dp),
            style = MaterialTheme.typography.displayLarge
        )
        Text(
            text = stringResource(id = R.string.task_name),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = 18.dp)
        )
        TextField(
            value = title,
            onValueChange = { onTitleChanged(it) },
            textStyle = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .padding(top = 10.dp)
                .width(250.dp),
            maxLines = 3,
            placeholder = {
                Text(
                    text = stringResource(id = R.string.name),
                    color = MaterialTheme.colorScheme.onTertiary,
                    style = MaterialTheme.typography.displaySmall
                )
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                focusedContainerColor = MaterialTheme.colorScheme.background,
                cursorColor = MaterialTheme.colorScheme.onPrimary
            )
        )
    }


}


@Preview
@Composable
fun PreviewNewTaskHeader() {
    TaskTrekTheme {
        NewTaskHeader(
            modifier = Modifier,
            title = "test preview",
            onTitleChanged = {},
            navigateBackToHomeScreen = {}
        )
    }
}