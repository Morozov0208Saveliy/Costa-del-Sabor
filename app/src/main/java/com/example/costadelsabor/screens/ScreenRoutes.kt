package com.example.costadelsabor.screens
//еще раз прочесть теорию
enum class ScreenRoutes(val route: String) {
    StartScreen("StartScreen"),
    RegisterScreen("RegisterScreen"),
    WelcomeScreen("WelcomeScreen"),
    MainScreen("MainScreen");

    companion object{
        fun fromRoute(route: String?): ScreenRoutes = when (route?.substringBefore("/")) {
            StartScreen.route -> StartScreen
            RegisterScreen.route -> RegisterScreen
            WelcomeScreen.route -> WelcomeScreen
            MainScreen.route -> MainScreen
            null -> StartScreen
            else -> throw IllegalArgumentException("Route $route is not recognized.")
        }
    }

}