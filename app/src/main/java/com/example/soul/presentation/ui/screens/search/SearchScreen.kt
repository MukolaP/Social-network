package com.example.soul.presentation.ui.screens.search

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.soul.presentation.ui.components.BottomNavigationView

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = viewModel()
) {
    BottomNavigationView(navController = navController)
}