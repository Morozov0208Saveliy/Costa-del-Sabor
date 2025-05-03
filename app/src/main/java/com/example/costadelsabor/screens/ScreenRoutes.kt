package com.example.costadelsabor.screens

enum class ScreenRoutes(val route: String) {
    StartScree("StartScreen"),
    RegisterScreen("RegisterScreen"),
    WelcomeScreen("WelcomeScreen"),
    MainScreen("MainScreen");

    companion object{
        fun fromRoute(route: String?): ScreenRoutes = when (route?.substringBefore("/")) {
            StartScree.route -> StartScree
            RegisterScreen.route -> RegisterScreen
            WelcomeScreen.route -> WelcomeScreen
            MainScreen.route -> MainScreen
            null -> StartScree
            else -> throw IllegalArgumentException("Route $route is not recognized.")
        }
    }

}