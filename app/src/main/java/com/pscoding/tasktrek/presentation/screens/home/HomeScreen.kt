package com.pscoding.tasktrek.presentation.screens.home

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.R
import com.pscoding.tasktrek.presentation.components.home_screen.BottomCalendar
import com.pscoding.tasktrek.presentation.components.home_screen.HomeHeader
import com.pscoding.tasktrek.presentation.components.home_screen.MyTasks
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToNewTaskScreen: () -> Unit
) {
    Column(
        modifier = modifier.padding(12.dp)
    ) {
        HomeHeader(
            modifier = Modifier.weight(0.23f),
            userImage = R.drawable.ic_user_avatar_defalt,
            openMenu = { navigateToNewTaskScreen() },
            changeImage = {}
        )

        Spacer(Modifier.height(4.dp))

        MyTasks(
            modifier = Modifier.weight(0.25f)
        )

        Spacer(Modifier.height(4.dp))

        BottomCalendar(
            modifier = Modifier.weight(0.23f)
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    TaskTrekTheme {
        HomeScreen(
            navigateToNewTaskScreen ={}
        )
    }
}