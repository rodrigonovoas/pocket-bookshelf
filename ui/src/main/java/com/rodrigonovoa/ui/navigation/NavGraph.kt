package com.rodrigonovoa.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rodrigonovoa.domain.usecase.GetBooksUseCase
import com.rodrigonovoa.ui.main.HomeScreen
import com.rodrigonovoa.ui.main.SettingsScreen
import com.rodrigonovoa.ui.screens.searchScreen.SearchScreen
import com.rodrigonovoa.ui.screens.searchScreen.SearchScreenViewModel
import org.koin.androidx.compose.get

@Composable
fun NavGraph(navController: NavHostController) {
    val getBooksUseCase: GetBooksUseCase = get()
    val viewModel = remember { SearchScreenViewModel(getBooksUseCase) }


    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable("home") { HomeScreen() }
        composable("search") { SearchScreen(viewModel) }
        composable("settings") { SettingsScreen() }
    }
}
