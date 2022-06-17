package com.example.soul.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.soul.presentation.ui.screens.ApplicationScreen
import com.example.soul.presentation.ui.theme.AppTheme
import com.example.soul.presentation.ui.theme.SoulTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoulTheme(darkTheme = isLight.value) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(AppTheme.colors.primaryBackground)
                ) {
                    ApplicationScreen()
                }
            }
        }
    }
}
