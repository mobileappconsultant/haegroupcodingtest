package com.haehome.ui.navigation

sealed class Routes(val route: String) {
    object HomeScreen : Routes("homeScreen")
    object AppDrawerScreen : Routes("appDrawerScreen")
}
