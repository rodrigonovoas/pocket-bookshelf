package com.rodrigonovoa.ui.screens.searchScreen

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SearchScreen(
    viewModel: SearchScreenViewModel
) {
    Button(
        onClick = { viewModel.getBooks() }
    ) {
        Text(text = "Púlsame")
    }
}