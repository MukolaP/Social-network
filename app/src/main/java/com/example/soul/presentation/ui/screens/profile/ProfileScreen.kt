package com.example.soul.presentation.ui.screens.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.soul.app.isLight
import com.example.soul.navigation.NavigationTree
import com.example.soul.presentation.ui.components.BottomNavigationView
import com.example.soul.presentation.ui.theme.AppTheme.colors

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = viewModel()
) {
    var expanded: Boolean by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Your nickname",
                            modifier = Modifier
                                .weight(1F)
                                .padding(top = 10.dp),
                            color = colors.primaryTextColor,
                        )

                        Column {
                            IconButton(
                                onClick = {
                                    expanded = true
                                },
                                modifier = Modifier.padding(end = 16.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Меню",
                                    tint = colors.primaryButtonColor
                                )
                            }

                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                DropdownMenuItem(onClick = {
                                    navController.navigate(NavigationTree.Login.name)
                                    expanded = false
                                }) {
                                    Text("Exit")
                                }
                                DropdownMenuItem(onClick = {
                                    expanded = false
                                }) {
                                    Text("Settings")
                                }
                                DropdownMenuItem(onClick = {
                                    isLight.value = !isLight.value
                                    expanded = false
                                }) {
                                    Text("Change theme")
                                }
                            }
                        }
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, start = 32.dp)
                    .height(70.dp),
            ) {

                Icon(
                    Icons.Filled.SupervisorAccount,
                    contentDescription = "Аватарка",
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(64.dp)
                        .border(
                            width = 1.dp,
                            color = colors.primaryTextColor,
                            shape = RoundedCornerShape(5.dp)
                        ),
                    tint = colors.primaryTextColor
                )

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1F),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "0", color = colors.primaryTextColor)
                    Text(text = "Posts", color = colors.primaryTextColor)
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1F),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "0", color = colors.primaryTextColor)
                    Text(text = "Readers", color = colors.primaryTextColor)
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1F),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "0", color = colors.primaryTextColor)
                    Text(text = "Tracked", color = colors.primaryTextColor)
                }

            }

            Button(
                onClick = { navController.navigate(NavigationTree.Edit.name) },
                modifier = Modifier
                    .padding(top = 64.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colors.primaryButtonColor,
                    contentColor = colors.primaryTextColor
                )
            ) {
                Text(
                    text = "Edit profile",
                    color = colors.secondaryTextColor,
                    modifier = Modifier.background(color = colors.primaryButtonColor)
                )
            }

            BottomNavigationView(navController = navController)
        }
    }
}