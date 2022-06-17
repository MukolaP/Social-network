package com.example.soul.presentation.ui.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.soul.navigation.NavigationTree
import com.example.soul.presentation.ui.theme.AppTheme.colors

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {
    var nickname: String by rememberSaveable { mutableStateOf("") }
    var password: String by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            text = "Log in",
                            modifier = Modifier
                                .weight(1F)
                                .padding(top = 8.dp),
                            color = colors.primaryTextColor,
                        )

                        Spacer(modifier = Modifier.weight(1F))

                        Text(
                            text = "Made in company(Mukola Pulupiv)",
                            color = colors.primaryTextColor,
                            modifier = Modifier
                                .background(
                                    color = colors.primaryViewBackground,
                                    shape = MaterialTheme.shapes.small.copy(
                                        bottomEnd = CornerSize(20), bottomStart = CornerSize(20)
                                    )
                                )
                                .padding(
                                    10.dp, 10.dp, 10.dp, 10.dp
                                ),
                            style = TextStyle(
                                shadow = Shadow(
                                    colors.primaryShadowColor,
                                    Offset(10.0f, 16.5f),
                                    1.0f
                                )
                            ),
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
                .background(color = colors.primaryBackground),
        ) {
            Spacer(modifier = Modifier.heightIn(50.dp))

            TextField(
                value = nickname,
                onValueChange = {
                    nickname = it
                },
                label = {
                    Text(text = "Nickname ", color = colors.primaryHintColor)
                },
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.small.copy(
                    bottomEnd = CornerSize(20),
                    bottomStart = CornerSize(20)
                ),
                singleLine = true,
            )

            Spacer(modifier = Modifier.heightIn(50.dp))

            TextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = {
                    Text(text = "Password", color = colors.primaryHintColor)
                },
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.small.copy(
                    bottomEnd = CornerSize(20),
                    bottomStart = CornerSize(20)
                ),
                singleLine = true
            )

            Button(
                onClick = {
                    navController.navigate(NavigationTree.Main.name)
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, top = 275.dp, end = 32.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colors.accentColor,
                    contentColor = colors.primaryButtonTextColor
                )
            ) {
                Text(text = "Log in")
            }

            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 50.dp, top = 16.dp)
            ) {
                Text(
                    modifier = Modifier
                        .clickable(enabled = true) {
                            navController.navigate(NavigationTree.Registration.name)
                        },
                    text = "Sign in",
                    color = colors.accentColor
                )
            }

        }
    }
}