package com.pscoding.tasktrek.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    homeScreenContent: @Composable () -> Unit,
    newTaskScreenContent: @Composable () -> Unit,
    viewTaskScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route) {
            homeScreenContent()
        }
        composable(Screen.NewTaskScreen.route) {
            newTaskScreenContent()
        }
        composable(Screen.ViewTaskScreen.route) {
            viewTaskScreenContent()
        }
    }
}