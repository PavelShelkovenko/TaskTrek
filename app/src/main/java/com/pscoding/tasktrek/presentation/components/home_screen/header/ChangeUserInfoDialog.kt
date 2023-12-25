package com.pscoding.tasktrek.presentation.components.home_screen.header

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.R
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme

@Composable
fun ChangeUserInfoDialog(
    userName: String,
    userStatus: String,
    onUserNameChanged: (String) -> Unit,
    onUserStatusChanged: (String) -> Unit,
) {

    var currentUserName by remember {
        mutableStateOf(userName)
    }
    var currentUserStatus by remember {
        mutableStateOf(userStatus)
    }

    val canSaveUserInfo = (
        currentUserName.isNotBlank() && currentUserStatus.isNotBlank() &&
        currentUserName.length < 30  && currentUserStatus.length < 30
    )

    Box(
        modifier = Modifier
            .width(340.dp)
            .height(340.dp)
            .clip(RoundedCornerShape(42.dp))
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(0.05f))
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.change_user_info_dialog_title),
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Spacer(modifier = Modifier.weight(0.1f))
            OutlinedTextField(
                value = currentUserName,
                onValueChange = { newUserName ->
                    currentUserName = newUserName
                },
                textStyle = MaterialTheme.typography.displayMedium,
                label = {
                    Text(text = stringResource(id = R.string.change_user_info_dialog_name_label))
                },
                isError = (currentUserName.isBlank() || currentUserName.length >= 30),
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
                    when {
                        currentUserName.isBlank() -> {
                            Text(
                                text = stringResource(
                                    id = R.string.change_user_info_dialog_empty_name_error
                                )
                            )
                        }

                        currentUserName.length >= 30 -> {
                            Text(
                                text = stringResource(
                                    id = R.string.to_many_characters_error
                                )
                            )
                        }
                    }
                })
            Spacer(modifier = Modifier.weight(0.05f))
            OutlinedTextField(
                value = currentUserStatus,
                onValueChange = { newUserStatus ->
                    currentUserStatus = newUserStatus
                },
                textStyle = MaterialTheme.typography.displayMedium,
                label = {
                    Text(text = stringResource(id = R.string.change_user_info_dialog_status_label))
                },
                isError = (currentUserStatus.isBlank() || currentUserStatus.length >= 30),
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
                    when {
                        currentUserStatus.isBlank() -> {
                            Text(
                                text = stringResource(
                                    id = R.string.change_user_info_dialog_empty_status_error
                                )
                            )
                        }

                        currentUserStatus.length >= 30 -> {
                            Text(
                                text = stringResource(
                                    id = R.string.to_many_characters_error
                                )
                            )
                        }
                    }
                })
            Spacer(modifier = Modifier.weight(0.05f))
            Button(
                onClick = {
                    if (canSaveUserInfo) {
                        onUserNameChanged(currentUserName)
                        onUserStatusChanged(currentUserStatus)
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
                    text = stringResource(id = R.string.save_button_text),
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
        ChangeUserInfoDialog(
            userName = "Marco Cochran",
            userStatus = "electram",
            onUserNameChanged = {},
            onUserStatusChanged = {}
        )
    }
}