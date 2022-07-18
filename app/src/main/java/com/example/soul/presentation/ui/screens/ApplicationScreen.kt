package com.example.soul.presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.soul.navigation.NavigationTree
import com.example.soul.presentation.ui.screens.chat.ChatScreen
import com.example.soul.presentation.ui.screens.chat.ChatViewModel
import com.example.soul.presentation.ui.screens.chats.ChatsScreen
import com.example.soul.presentation.ui.screens.chats.ChatsViewModel
import com.example.soul.presentation.ui.screens.edit.EditScreen
import com.example.soul.presentation.ui.screens.edit.EditViewModel
import com.example.soul.presentation.ui.screens.login.LoginScreen
import com.example.soul.presentation.ui.screens.login.LoginViewModel
import com.example.soul.presentation.ui.screens.main.MainScreen
import com.example.soul.presentation.ui.screens.main.MainViewModel
import com.example.soul.presentation.ui.screens.profile.ProfileScreen
import com.example.soul.presentation.ui.screens.profile.ProfileViewModel
import com.example.soul.presentation.ui.screens.registration.RegistrationScreen
import com.example.soul.presentation.ui.screens.registration.RegistrationViewModel
import com.example.soul.presentation.ui.screens.search.SearchScreen
import com.example.soul.presentation.ui.screens.search.SearchViewModel
import com.example.soul.presentation.ui.screens.settings.SettingsScreen
import com.example.soul.presentation.ui.screens.settings.SettingsViewModel

@Composable
fun ApplicationScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationTree.Login.name) {
        composable(NavigationTree.Login.name) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(viewModel = loginViewModel, navController = navController)
        }
        composable(NavigationTree.Registration.name) {
            val registrationViewModel = hiltViewModel<RegistrationViewModel>()
            RegistrationScreen(viewModel = registrationViewModel, navController = navController)
        }
        composable(NavigationTree.Main.name) {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(viewModel = mainViewModel, navController = navController)
        }
        composable(NavigationTree.Search.name) {
            val searchViewModel = hiltViewModel<SearchViewModel>()
            SearchScreen(viewModel = searchViewModel, navController = navController)
        }
        composable(NavigationTree.Chats.name) {
            val chatsViewModel = hiltViewModel<ChatsViewModel>()
            ChatsScreen(viewModel = chatsViewModel, navController = navController)
        }
        composable(NavigationTree.Chat.name) {
            val chatViewModel = hiltViewModel<ChatViewModel>()
            ChatScreen(viewModel = chatViewModel, navController = navController)
        }
        composable(NavigationTree.Profile.name) {
            val profileViewModel = hiltViewModel<ProfileViewModel>()
            ProfileScreen(viewModel = profileViewModel, navController = navController)
        }
        composable(NavigationTree.Edit.name) {
            val editViewModel = hiltViewModel<EditViewModel>()
            EditScreen(viewModel = editViewModel, navController = navController)
        }
        composable(NavigationTree.Settings.name) {
            val settingsViewModel = hiltViewModel<SettingsViewModel>()
            SettingsScreen(viewModel = settingsViewModel, navController = navController)
        }
    }
}