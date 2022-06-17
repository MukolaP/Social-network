package com.example.soul.app

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp

val isLight = mutableStateOf(false)

@HiltAndroidApp
class App : Application()