package com.haehome.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.haehome.App
import com.haehome.data.network.HttpConnection
import com.haehome.ui.AppDrawerScreen
import com.haehome.ui.composable.HomeScreen
import com.haehome.ui.viewModel.MainViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val mainViewModel = viewModel {
        MainViewModel(HttpConnection())
    }
    NavHost(navController = navController, startDestination = Routes.HomeScreen.route){
        composable(Routes.HomeScreen.route) {
            HomeScreen(App.batteryPercent ?: 0.0f, mainViewModel) {
                navController.navigate(Routes.AppDrawerScreen.route)
            }
        }
        composable(Routes.AppDrawerScreen.route){
            AppDrawerScreen()
        }
    }
}