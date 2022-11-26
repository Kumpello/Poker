package com.kumpello.poker.ui.navigation

sealed class LoginRoutes(val route: String) {
    object Login : LoginRoutes("Login")
    object SignUp : LoginRoutes("SignUp")
    object Splash : LoginRoutes("Splash")
}
