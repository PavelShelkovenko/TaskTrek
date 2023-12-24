package com.pscoding.tasktrek.presentation.components.home_screen.header

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import com.pscoding.tasktrek.R

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
    userImage: ByteArray?,
    userName: String,
    userStatus: String,
    addNewTask: () -> Unit,
    onUserImageChanged: (ByteArray) -> Unit,
    onUserNameChanged: (String) -> Unit,
    onUserStatusChanged: (String) -> Unit,
) {

    val contentResolver = LocalContext.current.contentResolver

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            val receivedByteArray = uri?.let {
                contentResolver.openInputStream(it)?.use {
                    it.readBytes()
                }
            }
            receivedByteArray?.let { data ->
                onUserImageChanged(data)
            }
        }
    )

    val openDialog = remember {
        mutableStateOf(false)
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
            ChangeUserInfoDialog(
                userName = userName,
                userStatus = userStatus,
                onUserNameChanged = { newUserName ->
                    onUserNameChanged(newUserName)
                    openDialog.value = false
                },
                onUserStatusChanged = { newUserStatus ->
                    onUserStatusChanged(newUserStatus)
                    openDialog.value = false
                },
            )
        }
    }

    Column(
        modifier = modifier.padding(top = 12.dp, bottom = 12.dp, end = 12.dp, start = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { addNewTask() }) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    tint = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.size(32.dp),
                    contentDescription = null
                )
            }
        }
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .aspectRatio(1f)
                    .clickable { launcher.launch("image/*") },
                model = userImage,
                error = painterResource(id = R.drawable.ic_user_avatar_default),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.clickable { openDialog.value = true },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = userName,
                        color = MaterialTheme.colorScheme.onSecondary,
                        style = MaterialTheme.typography.displayMedium,
                    )
                    Text(
                        text = userStatus,
                        color = MaterialTheme.colorScheme.onTertiary,
                        modifier = Modifier.padding(top = 4.dp),
                        style = MaterialTheme.typography.displaySmall,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HeaderProfilePreview() {
    HomeHeader(
        userImage = null,
        userName = "Lelia Hinton",
        userStatus = "suspendisse",
        addNewTask = {},
        onUserImageChanged = {},
        onUserNameChanged = {},
        onUserStatusChanged = {},
    )
}