package com.example.soul.presentation.ui.screens.chats

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.soul.domain.model.Message
import com.example.soul.presentation.ui.components.BottomNavigationView
import com.example.soul.presentation.ui.components.MessageItem
import com.example.soul.presentation.ui.theme.AppTheme.colors

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChatsScreen(
    navController: NavController,
    viewModel: ChatsViewModel = viewModel()
) {
    var showClearButton by remember { mutableStateOf(false) }
    val message: State<List<Message>?> = viewModel.message.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(Modifier.fillMaxSize()) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = "",
                            label = { Text(text = "Search chat", color = colors.primaryTextColor) },
                            onValueChange = {},
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = colors.primaryBackground,
                                textColor = colors.primaryTextColor
                            ),
                            singleLine = true,
                        )
                    }
                },
                backgroundColor = colors.primaryBackground,
                contentColor = colors.primaryBackground,
                elevation = 12.dp,
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colors.primaryBackground)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F),
            ) {
                item {
                    message.value?.map { item ->
                        MessageItem(
                            item = item,
                            backgroundColor = colors.primaryBackground,
                            textColor = colors.primaryTextColor
                        )
                    }
                }
            }

            BottomNavigationView(navController = navController)
        }
    }
}