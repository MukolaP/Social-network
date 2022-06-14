package com.example.soul.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.soul.navigation.NavigationTree
import com.example.soul.presentation.ui.theme.AppTheme

@Composable
fun BottomNavigationView(navController: NavController) {

    Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.fillMaxHeight()) {

        BottomAppBar(
            backgroundColor = AppTheme.colors.primaryBackground,
            contentColor = AppTheme.colors.accentColor
        ) {

            IconButton(onClick = {
                navController.navigate(NavigationTree.Main.name)
            }, modifier = Modifier.weight(1F)) {
                Icon(Icons.Filled.Menu, contentDescription = "Меню")
            }

            IconButton(onClick = {
                navController.navigate(NavigationTree.Search.name)
            }, modifier = Modifier.weight(1F)) {
                Icon(Icons.Filled.Search, contentDescription = "Поиск")
            }

            IconButton(onClick = {
                navController.navigate(NavigationTree.Chats.name)
            }, modifier = Modifier.weight(1F)) {
                Icon(Icons.Filled.Chat, contentDescription = "Информация о приложении")
            }

            IconButton(onClick = {
                navController.navigate(NavigationTree.Profile.name)
            }, modifier = Modifier.weight(1F)) {
                Icon(Icons.Filled.SupervisorAccount, contentDescription = "Избранное")
            }
        }
    }

}