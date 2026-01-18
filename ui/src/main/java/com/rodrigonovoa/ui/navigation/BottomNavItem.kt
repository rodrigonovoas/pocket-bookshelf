package com.rodrigonovoa.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem("home", "Biblioteca", Icons.Default.Home)
    object Search : BottomNavItem("search", "Búsqueda", Icons.Default.Search)
    object Settings : BottomNavItem("settings", "Ajustes", Icons.Default.Settings)
}
