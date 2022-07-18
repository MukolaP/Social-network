package com.example.soul.presentation.ui.screens.registration

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.soul.domain.model.User
import com.example.soul.navigation.NavigationTree
import com.example.soul.presentation.ui.theme.AppTheme.colors

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegistrationScreen(
    navController: NavController,
    viewModel: RegistrationViewModel = viewModel()
) {

    Scaffold(
        topBar = {
            RegistrationTopBar(navController = navController)
        }
    ) {
        RegistrationBody(navController = navController, viewModel = viewModel)
    }
}

@Composable
fun RegistrationTopBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(text = "Registration", color = colors.primaryTextColor)
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.navigate(NavigationTree.Login.name)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    modifier = Modifier,
                    contentDescription = "back",
                    tint = colors.primaryButtonColor
                )
            }
        },
        backgroundColor = colors.primaryBackground,
        contentColor = colors.primaryBackground,
        elevation = 12.dp,
    )
}

@Composable
fun RegistrationBody(
    navController: NavController,
    viewModel: RegistrationViewModel
) {

    var nickname: String by rememberSaveable { mutableStateOf("") }
    var password: String by rememberSaveable { mutableStateOf("") }
    var email: String by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colors.primaryBackground)
    ) {
        Spacer(modifier = Modifier.heightIn(50.dp))

        TextField(
            value = nickname,
            onValueChange = {
                nickname = it
            },
            label = {
                Text(text = "Nickname ", color = colors.primaryHint)
            },
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.small.copy(
                bottomEnd = CornerSize(20),
                bottomStart = CornerSize(20)
            ),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = colors.primaryTextColor
            )
        )

        Spacer(modifier = Modifier.heightIn(50.dp))

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(text = "Password", color = colors.primaryHint)
            },
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.small.copy(
                bottomEnd = CornerSize(20),
                bottomStart = CornerSize(20)
            ),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = colors.primaryTextColor
            )
        )

        Spacer(modifier = Modifier.heightIn(50.dp))

        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(text = "Email", color = colors.primaryHint)
            },
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.small.copy(
                bottomEnd = CornerSize(20),
                bottomStart = CornerSize(20)
            ),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = colors.primaryTextColor
            )
        )

        Button(
            onClick = {
                viewModel.validateAccount(
                    navController,
                    User(
                        nickname = nickname,
                        password = password,
                        email = email
                    )
                )
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, top = 175.dp, end = 32.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colors.accentColor,
                contentColor = colors.primaryTextColor
            )
        ) {
            Text(text = "Sign in")
        }
    }
}