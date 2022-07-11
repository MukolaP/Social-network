package com.example.soul.presentation.ui.screens.edit

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        },
        backgroundColor = colors.primaryBackground
    ) {
        Column(
            modifier = Modifier.padding(top = 36.dp),
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

            Text(
                text = "Change picture",
                color = colors.primaryTextColor,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )

            Text(
                text = "123",
                color = colors.primaryTextColor,
                fontSize = 18.sp
            )
        }
    }
}