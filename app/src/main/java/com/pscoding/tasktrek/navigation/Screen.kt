package com.pscoding.tasktrek.navigation

sealed class Screen(
    val route: String
) {

    object HomeScreen : Screen(ROUTE_HOME_SCREEN)
    object NewTaskScreen : Screen(ROUTE_NEW_TASK_SCREEN)
    object ViewTaskScreen: Screen(ROUTE_VIEW_TASK_SCREEN)

    private companion object {
        const val ROUTE_HOME_SCREEN = "home_screen"
        const val ROUTE_NEW_TASK_SCREEN = "new_task_screen"
        const val ROUTE_VIEW_TASK_SCREEN = "view_task_screen"
    }
}