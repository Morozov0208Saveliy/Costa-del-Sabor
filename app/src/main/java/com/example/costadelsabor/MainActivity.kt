package com.example.costadelsabor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.costadelsabor.screens.StartScreen
import com.example.costadelsabor.screens.MainScreen
import com.example.costadelsabor.screens.RegisterScreen
import com.example.costadelsabor.screens.ScreenRoutes
import com.example.costadelsabor.screens.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = ScreenRoutes.StartScree.route
            ) {

                composable(ScreenRoutes.StartScree.route) {
                    StartScreen(
                        navigateToRegister = { navController.navigate(ScreenRoutes.RegisterScreen.route) },
                        navigateToMain = { navController.navigate(ScreenRoutes.MainScreen.route) },
                        navigaionToWelcome = { navController.navigate(ScreenRoutes.WelcomeScreen.route) }
                    )
                }
                composable(ScreenRoutes.RegisterScreen.route) {
                    RegisterScreen(
                        navigationToStart = { navController.navigate(ScreenRoutes.StartScree.route) },
                        navigationToMain = { navController.navigate(ScreenRoutes.MainScreen.route) }
                    )
                }
                composable(ScreenRoutes.WelcomeScreen.route) {
                    WelcomeScreen(
                        navigationToStart = { navController.navigate(ScreenRoutes.StartScree.route) },
                        navigationToMain = { navController.navigate(ScreenRoutes.MainScreen.route) }
                    )
                }
                composable("MainScreen") {
                    MainScreen(navController)
                }
            }

        }
    }
}

