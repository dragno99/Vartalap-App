package com.example.suruchat_app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.suruchat_app.data.local.UserPreferences
import com.example.suruchat_app.ui.components.ScaffoldUse
import com.example.suruchat_app.ui.screens.home.HomeViewModel
import com.example.suruchat_app.ui.theme.SuruChatAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()
    private var userPreferences: UserPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuruChatAppTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    val context = LocalContext.current
                    userPreferences = UserPreferences(context)
                    ScaffoldUse(navController = navController,viewModel = viewModel,userPreferences = userPreferences!!)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        userPreferences = null
    }
}

