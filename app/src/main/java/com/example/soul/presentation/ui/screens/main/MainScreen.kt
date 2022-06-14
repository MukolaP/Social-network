package com.example.soul.presentation.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.soul.presentation.ui.components.BottomNavigationView

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = viewModel()
) {
    BottomNavigationView(navController = navController)
}


