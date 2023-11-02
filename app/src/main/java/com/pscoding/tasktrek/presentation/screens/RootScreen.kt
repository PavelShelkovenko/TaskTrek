package com.pscoding.tasktrek.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pscoding.tasktrek.navigation.AppNavGraph
import com.pscoding.tasktrek.navigation.Screen
import com.pscoding.tasktrek.navigation.rememberNavigationState
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme

@Composable
fun RootScreen(
    modifier: Modifier = Modifier
) {

    val navigationState = rememberNavigationState()
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    AppNavGraph(
        navHostController = navigationState.navHostController,
        homeScreenContent = {
            HomeScreen(
                modifier = Modifier.fillMaxSize()
            )
        },
        newTaskScreenContent = {
            NewTaskScreen()
        }
    )
}