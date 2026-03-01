package com.rodrigonovoa.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rodrigonovoa.domain.usecase.GetBookDetailUseCase
import com.rodrigonovoa.domain.usecase.SearchBooksUseCase
import com.rodrigonovoa.ui.main.HomeScreen
import com.rodrigonovoa.ui.main.SettingsScreen
import com.rodrigonovoa.ui.screens.detailScreen.DetailScreen
import com.rodrigonovoa.ui.screens.detailScreen.DetailScreenViewModel
import com.rodrigonovoa.ui.screens.searchScreen.SearchScreen
import com.rodrigonovoa.ui.screens.searchScreen.SearchScreenViewModel
import org.koin.androidx.compose.get

@Composable
fun NavGraph(navController: NavHostController) {
    val searchBooksUseCase: SearchBooksUseCase = get()
    val getBookDetailUseCase: GetBookDetailUseCase = get()

    val searchViewModel = remember { SearchScreenViewModel(searchBooksUseCase) }
    val detailScreenViewModel = remember { DetailScreenViewModel(getBookDetailUseCase) }

    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable("home") { HomeScreen() }
        composable("search") { SearchScreen(searchViewModel, navController) }
        composable("settings") { SettingsScreen() }
        composable(
            route = "detail/{bookId}",
            arguments = listOf(
                navArgument("bookId") { type = NavType.StringType }
            )
        )
        { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString("bookId")
            DetailScreen(detailScreenViewModel, bookId)
        }
    }
}
