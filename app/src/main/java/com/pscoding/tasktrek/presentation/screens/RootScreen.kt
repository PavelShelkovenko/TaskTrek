package com.pscoding.tasktrek.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pscoding.tasktrek.navigation.AppNavGraph
import com.pscoding.tasktrek.navigation.Screen
import com.pscoding.tasktrek.navigation.rememberNavigationState

@Composable
fun RootScreen() {

    val navigationState = rememberNavigationState()
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    AppNavGraph(
        navHostController = navigationState.navHostController,
        homeScreenContent = {
            HomeScreen(
                modifier = Modifier.fillMaxSize()
            ) {
                navigationState.navigateTo(Screen.NewTaskScreen.route)
            }
        },
        newTaskScreenContent = {
            NewTaskScreen(
                modifier = Modifier.fillMaxSize()
            )
        }
    )
}