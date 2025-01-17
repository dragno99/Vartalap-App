package com.example.suruchat_app.ui.util

sealed class Routes(val route: String){
    object Home: Routes("home_screen")
    object Splash: Routes("splash_screen")
    object Login: Routes("login_screen")
    object SignUp: Routes("signup_screen")
}
