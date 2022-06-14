package com.example.soul.presentation.ui.screens.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = viewModel()
) {
    Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.fillMaxHeight()){
        BottomAppBar {
            IconButton(onClick = {  }) {
                Icon(Icons.Filled.Menu, contentDescription = "Меню")
            }
            Spacer(Modifier.weight(1f, true))

            IconButton(onClick = { }) {
                Icon(Icons.Filled.Info, contentDescription = "Информация о приложении")
            }
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Search, contentDescription = "Избранное")
            }
        }
    }
}


