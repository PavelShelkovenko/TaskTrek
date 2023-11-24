package com.pscoding.tasktrek.presentation.components.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.R

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
    userName: String = "Valeria Anderson",
    userStatus: String = "Student",
    userImage: Int,
    addNewTask: () -> Unit,
    changeImage: () -> Unit,
) {
    Column(
        modifier = modifier.padding(12.dp),
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
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .clickable { changeImage() },
                painter = painterResource(id = userImage),
                contentDescription = null
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
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

@Preview
@Composable
fun HeaderProfilePreview() {
    HomeHeader(
        modifier = Modifier,
        userImage = R.drawable.ic_user_avatar_defalt,
        addNewTask = {},
        changeImage = {}
    )
}