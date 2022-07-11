package com.example.soul.presentation.ui.theme

import androidx.compose.ui.graphics.Color

data class Colors(
    val primaryBackground: Color,
    val primaryButtonColor: Color,
    val primaryHint: Color,
    val primaryTextColor: Color,
    val primaryButtonTextColor: Color,
    val secondaryTextColor: Color,
    val primaryViewBackground: Color,
    val primaryShadowColor: Color,
    val accentColor: Color,
)

val darkPalette = Colors(
    primaryBackground = Color(0xFF2b3031),
    primaryButtonColor = Color(0xFF8e9392),
    primaryHint = Color(0xFF8f9b9e),
    primaryTextColor = Color(0xFFcbcecb),
    primaryButtonTextColor = Color(0xFFcbcecb),
    secondaryTextColor = Color.DarkGray,
    primaryViewBackground = Color(0xFF161819),
    primaryShadowColor = Color.DarkGray,
    accentColor = Color(0xFFda8006)
)

val lightPalette = Colors(
    primaryBackground = Color.LightGray,
    primaryButtonColor = Color(0xFFda8006),
    primaryHint = Color.DarkGray,
    primaryTextColor = Color.Black,
    primaryButtonTextColor = Color(0xFFcbcecb),
    secondaryTextColor = Color.LightGray,
    primaryViewBackground = Color.Gray,
    primaryShadowColor = Color.DarkGray,
    accentColor = Color(0xFF001FFF)
)
