package com.example.soul.presentation.ui.screens.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.soul.navigation.NavigationTree
import com.example.soul.presentation.ui.theme.AppTheme.colors

@Composable
fun ChatScreen(
    navController: NavController,
    viewModel: ChatViewModel
) {
    val message: List<String> = viewModel.message

    Scaffold(
        topBar = {
            ChatTopBar(navController)
        },
        backgroundColor = colors.primaryBackground
    ) {
        Column {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                item {
                    message.map { message ->
                        MessageItem(
                            message = message,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            ChatDownLayerScreen()
        }
    }
}

@Composable
fun ChatTopBar(navController: NavController) {

    TopAppBar(
        title = {
            Text(
                text = "User nickname", color = colors.primaryTextColor,
            )
        },
        backgroundColor = colors.primaryBackground,
        navigationIcon = {
            IconButton(
                onClick = { navController.navigate(NavigationTree.Chats.name) }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = colors.primaryButtonColor,
                    contentDescription = "Change theme"
                )
            }
        }
    )
}

@Composable
fun ChatDownLayerScreen() {
    var message: String by rememberSaveable { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 0.dp, end = 10.dp, bottom = 10.dp)
    ) {
        TextField(
            value = message,
            onValueChange = {
                message = it
            },
            label = {
                Text(text = "Your message", color = colors.primaryTextColor)
            },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = MaterialTheme.shapes.small.copy(
                bottomEnd = CornerSize(100),
                bottomStart = CornerSize(100)
            ),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = colors.primaryTextColor,
                backgroundColor = colors.primaryBackground,
                cursorColor = Color.White.copy(alpha = ContentAlpha.medium)
            ),
            textStyle = TextStyle(fontSize = MaterialTheme.typography.subtitle1.fontSize),
        )

        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Filled.Send,
                tint = colors.primaryButtonColor,
                contentDescription = "Send message"
            )
        }
    }
}

@Composable
fun MessageItem(message: String) {

    Card(
        modifier = Modifier
            .height(75.dp)
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        backgroundColor = colors.primaryViewBackground,
        elevation = 8.dp,
        shape = MaterialTheme.shapes.small.copy(CornerSize(100))
    ) {
        Row {
            Text(
                text = "03.04.2026", color = colors.primaryTextColor,
                modifier = Modifier.padding(start = 12.dp, top = 18.dp, bottom = 5.dp),
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = message, color = colors.primaryTextColor,
                modifier = Modifier.padding(start = 8.dp, top = 18.dp, bottom = 5.dp),
                maxLines = 1
            )

            Text(
                text = "(nickname)     ", color = colors.primaryTextColor,
                modifier = Modifier.padding(start = 8.dp, top = 18.dp, bottom = 5.dp),
                maxLines = 1
            )
        }
    }
}

