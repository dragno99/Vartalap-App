package com.example.suruchat_app.ui.components

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.suruchat_app.data.local.UserPreferences
import com.example.suruchat_app.ui.AppNavigation
import com.example.suruchat_app.ui.screens.home.HomeViewModel

@Composable
fun ScaffoldUse(
    navController: NavHostController,
    viewModel: HomeViewModel,
    userPreferences: UserPreferences
) {

    val scaffoldState = rememberScaffoldState()
    
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar() {

            }
        }
    ) { innerPadding ->
        AppNavigation(
            navController = navController,
            viewModel = viewModel,
            userPreferences = userPreferences,
            innerPadding = innerPadding
        )
    }
}