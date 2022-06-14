package com.example.soul.presentation.ui.theme

import androidx.compose.ui.graphics.Color

data class Colors(
    val primaryBackground: Color,
    val primaryButtonColor: Color,
    val primaryHintColor: Color,
    val primaryTextColor: Color,
    val primaryViewBackground: Color,
    val primaryShadowColor: Color,
    val accentColor: Color,
)

val darkPalette = Colors(
    primaryBackground = Color(0xFF2b3031),
    primaryButtonColor = Color(0xFF8e9392),
    primaryHintColor = Color(0xFF8f9b9e),
    primaryTextColor = Color(0xFFcbcecb),
    primaryViewBackground = Color(0xFF161819),
    primaryShadowColor = Color.DarkGray,
    accentColor = Color(0xFFda8006)
)

val lightPalette = Colors(
    primaryBackground = Color.LightGray,
    primaryButtonColor = Color(0xFFda8006),
    primaryHintColor = Color(0xFF8f9b9e),
    primaryTextColor = Color.Black,
    primaryViewBackground = Color.Gray,
    primaryShadowColor = Color.LightGray,
    accentColor = Color(0xFF001FFF)
)
