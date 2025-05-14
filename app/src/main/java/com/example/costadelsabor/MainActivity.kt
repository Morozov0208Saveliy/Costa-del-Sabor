package com.example.costadelsabor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.costadelsabor.retrofit.ProductApi
import com.example.costadelsabor.screens.StartScreen
import com.example.costadelsabor.screens.MainScreen
import com.example.costadelsabor.screens.RegisterScreen
import com.example.costadelsabor.screens.ScreenRoutes
import com.example.costadelsabor.screens.WelcomeScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")// Ссылка Api для получения данных
            .addConverterFactory(GsonConverterFactory.create())// создаем конвертер
            .build()
        val productApi = retrofit.create(ProductApi::class.java)// создаем интерфейс(инстация API)
        CoroutineScope(Dispatchers.IO).launch {
            val products = productApi.getProducts()
        }
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = ScreenRoutes.StartScreen.route
            ) {

                composable(ScreenRoutes.StartScreen.route) {
                    StartScreen(
                        navigateToRegister = { navController.navigate(ScreenRoutes.RegisterScreen.route) },
                        navigateToMain = { navController.navigate(ScreenRoutes.MainScreen.route) },
                        navigaionToWelcome = { navController.navigate(ScreenRoutes.WelcomeScreen.route) }
                    )
                }
                composable(ScreenRoutes.RegisterScreen.route) {
                    RegisterScreen(
                        navigationToStart = { navController.navigate(ScreenRoutes.StartScreen.route) },
                        navigationToMain = { navController.navigate(ScreenRoutes.MainScreen.route) }
                    )
                }
                composable(ScreenRoutes.WelcomeScreen.route) {
                    WelcomeScreen(
                        navigationToStart = { navController.navigate(ScreenRoutes.StartScreen.route) },
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

