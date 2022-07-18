package com.example.soul.presentation.ui.screens.edit

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.soul.navigation.NavigationTree
import com.example.soul.presentation.ui.theme.AppTheme.colors

@Composable
fun EditScreen(
    navController: NavController,
    viewModel: EditViewModel
) {
    Scaffold(
        topBar = {
            EditTopBar(navController)
        },
        backgroundColor = colors.primaryBackground
    ) {
        EditBody()
    }
}

@Composable
fun EditTopBar(navController: NavController) {

    TopAppBar(
        title = {
            Text(text = "Edit profile", color = colors.primaryTextColor)
        },
        navigationIcon = {
            IconButton(
                onClick = { navController.navigate(NavigationTree.Profile.name) }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = colors.primaryButtonColor,
                    contentDescription = "Change theme"
                )
            }
        },
        backgroundColor = colors.primaryBackground,
        contentColor = colors.primaryBackground,
        elevation = 12.dp,
    )
}

@Composable
fun EditBody() {

    var nickname: String by rememberSaveable { mutableStateOf("") }
    var userName: String by rememberSaveable { mutableStateOf("") }
    var biography: String by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(top = 48.dp),
    ) {
        Row {
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                Icons.Filled.SupervisorAccount,
                contentDescription = "Аватарка",
                modifier = Modifier
                    .height(64.dp)
                    .width(64.dp)
                    .weight(1f)
                    .border(
                        width = 1.dp,
                        color = colors.primaryTextColor,
                        shape = RoundedCornerShape(5.dp)
                    ),
                tint = colors.primaryTextColor
            )

            Spacer(modifier = Modifier.weight(1f))
        }

        Row {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Change main picture",
                color = colors.accentColor,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )

            Spacer(modifier = Modifier.weight(1f))
        }

        TextField(
            value = nickname,
            onValueChange = {
                nickname = it
            },
            label = {
                Text(text = "Name", color = colors.primaryTextColor)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
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

        TextField(
            value = userName,
            onValueChange = {
                userName = it
            },
            label = {
                Text(text = "User name", color = colors.primaryTextColor)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
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

        TextField(
            value = biography,
            onValueChange = {
                biography = it
            },
            label = {
                Text(text = "Biography", color = colors.primaryTextColor)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
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
    }
}