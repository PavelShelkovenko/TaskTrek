package com.pscoding.tasktrek.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pscoding.tasktrek.navigation.AppNavGraph
import com.pscoding.tasktrek.navigation.Screen
import com.pscoding.tasktrek.navigation.rememberNavigationState
import com.pscoding.tasktrek.presentation.screens.home.HomeScreen
import com.pscoding.tasktrek.presentation.screens.new_task.NewTaskScreen
import com.pscoding.tasktrek.presentation.screens.view_task_screen.ViewTaskScreen

@Composable
fun RootScreen() {

    val navigationState = rememberNavigationState()
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    AppNavGraph(
        navHostController = navigationState.navHostController,
        homeScreenContent = {
            HomeScreen(
                navigateToNewTaskScreen = {
                    navigationState.navigateTo(Screen.NewTaskScreen.route)
                },
                navigateToViewTaskScreen = {
                    navigationState.navigateTo(Screen.ViewTaskScreen.route)
                }
            )
        },
        newTaskScreenContent = { NewTaskScreen() },
        viewTaskScreenContent = { ViewTaskScreen() }
    )
}