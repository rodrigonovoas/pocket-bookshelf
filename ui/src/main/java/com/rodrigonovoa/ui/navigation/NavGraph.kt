package com.rodrigonovoa.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rodrigonovoa.ui.main.HomeScreen
import com.rodrigonovoa.ui.main.SearchScreen
import com.rodrigonovoa.ui.main.SettingsScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable("home") { HomeScreen() }
        composable("search") { SearchScreen() }
        composable("settings") { SettingsScreen() }
    }
}
