package com.haehome.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.haehome.App
import com.haehome.ui.AppDrawerScreen
import com.haehome.ui.composable.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HomeScreen.route){
        composable(Routes.HomeScreen.route) {
            HomeScreen(App.batteryPercent ?: 0.0f) {
                navController.navigate(Routes.AppDrawerScreen.route)
            }
        }
        composable(Routes.AppDrawerScreen.route){
            AppDrawerScreen()
        }
    }
}