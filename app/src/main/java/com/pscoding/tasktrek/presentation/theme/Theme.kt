package com.pscoding.tasktrek.presentation.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val darkColorScheme = darkColorScheme(
    primary = Color.White,
    secondary = Color.White,
    tertiary = Color.White,
    surface = Color.Black,
    background = Color(0xFF1C1C1C),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onTertiary = Color.LightGray,
    onSurface = Color.White,
    onBackground = Color.White,
)

private val lightColorScheme = lightColorScheme(
    primary = Color.Black,
    secondary = Color.White,
    tertiary = Color.White,
    surface = Color.Black,
    background = Color(0xFF1C1C1C),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onTertiary = Color.LightGray,
    onSurface = Color.White,
    onBackground = Color.White,
)

@Composable
fun TaskTrekTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    /*
    val colorScheme = when {
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    */

    val colorScheme = darkColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
//        SideEffect {
//            val window = (view.context as Activity).window
//            window.statusBarColor = colorScheme.primary.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
//        }
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb() // here change the color
            window.navigationBarColor = colorScheme.background.toArgb() // here change the color

            // here change the status bar element color
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = !darkTheme
        }

    }


    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}