package com.pscoding.tasktrek.presentation.components.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
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
    userAvatar: Int,
    openMenu: () -> Unit,
    changeAvatar: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(32.dp))
            .background(MaterialTheme.colorScheme.onBackground),
    ) {
        Column(
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { openMenu() }) {
                    Icon(
                        imageVector = Icons.Outlined.Menu,
                        tint = MaterialTheme.colorScheme.onSecondary,
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.padding(start = 20.dp, bottom = 20.dp).height(250.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .clickable { changeAvatar() },
                    painter = painterResource(id = userAvatar),
                    contentDescription = null
                )
                Column{
                    Text(
                        text = userName,
                        color = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier.padding(start = 20.dp, end = 10.dp),
                        style = MaterialTheme.typography.displayMedium,
                    )
                    Text(
                        text = userStatus,
                        color = MaterialTheme.colorScheme.onTertiary,
                        modifier = Modifier.padding(start = 20.dp, top = 4.dp),
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
        modifier = Modifier.height(250.dp).width(700.dp),
        userAvatar = R.drawable.ic_user_avatar_defalt,
        openMenu = {},
        changeAvatar = {}
    )
}