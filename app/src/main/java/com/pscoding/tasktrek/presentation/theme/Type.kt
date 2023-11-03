package com.pscoding.tasktrek.presentation.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pscoding.tasktrek.R

val comfortaaFamily = FontFamily(
    Font(R.font.comfortaa_thin, weight = FontWeight.Thin),
    Font(R.font.comfortaa_bold, weight = FontWeight.Bold),
    Font(R.font.comfortaa_regular, weight = FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displaySmall = TextStyle(
        fontFamily = comfortaaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = comfortaaFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
    ),
    displayLarge = TextStyle(
        fontFamily = comfortaaFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 22.sp,
    ),
)

