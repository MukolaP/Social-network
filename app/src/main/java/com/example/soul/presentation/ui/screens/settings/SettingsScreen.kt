package com.example.soul.presentation.ui.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.soul.navigation.NavigationTree
import com.example.soul.presentation.ui.theme.AppTheme.colors

data class Settings(val text: String, val icon: ImageVector)

@Composable
fun SettingsScreen(navController: NavController, viewModel: SettingsViewModel = viewModel()) {

    Scaffold(
        topBar = {
            SettingsTopBar()
        }
    ) {
        SettingsBody(viewModel = viewModel, navController = navController)
    }
}

@Composable
fun SettingsTopBar() {

    TopAppBar(
        title = {
            Text(text = "Settings", color = colors.primaryTextColor)
        },
        backgroundColor = colors.primaryBackground,
        contentColor = colors.primaryBackground,
        elevation = 12.dp,
    )
}

@Composable
fun SettingsBody(navController: NavController, viewModel: SettingsViewModel) {

    val settings: List<Settings> =
        listOf(
            Settings(text = "Invite friends", icon = Icons.Default.PersonAdd),
            Settings(text = "Notifications", icon = Icons.Default.Notifications),
            Settings(text = "Information", icon = Icons.Default.Info),
            Settings(text = "Help", icon = Icons.Default.Help)
        )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colors.primaryBackground)
    ) {

        LazyColumn() {
            item {
                settings.map { settings ->
                    SettingsItem(settings = settings)
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Back",
            color = colors.accentColor,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(bottom = 20.dp, start = 20.dp)
                .clickable { navController.navigate(NavigationTree.Profile.name) })
    }
}

@Composable
fun SettingsItem(settings: Settings) {
    val text = settings.text
    val icon = settings.icon

    Row(
        modifier = Modifier
            .padding(start = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = colors.primaryButtonColor
        )
        Text(
            text = text,
            color = colors.primaryTextColor,
            fontSize = 16.sp,
            modifier = Modifier
                .clickable { }
                .padding(top = 10.dp, bottom = 10.dp, start = 16.dp)
        )
    }
}
