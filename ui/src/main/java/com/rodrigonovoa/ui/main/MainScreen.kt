package com.rodrigonovoa.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.rodrigonovoa.ui.navigation.BottomBar
import com.rodrigonovoa.ui.navigation.NavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavGraph(navController)
        }
    }
}

@Composable
fun HomeScreen() {
    Text("Home Screen")
}

@Composable
fun SettingsScreen() {
    Text("Settings Screen")
}