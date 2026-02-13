package com.rodrigonovoa.ui.screens.searchScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.rodrigonovoa.domain.model.VolumeInfo

@Composable
fun SearchScreen(
    viewModel: SearchScreenViewModel
) {
    val books by viewModel.books.collectAsState()
    val booksQuery by viewModel.searchQuery.collectAsState()

    Column {
        TextField(
            value = booksQuery,
            onValueChange = { viewModel.onSearchChanged(it) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Search your book") }
        )

        LazyColumn {
            items(
                items = books,
                key = { book -> book.id }
            ) { book ->
                if (book.volumeInfoDto != null) {
                    SearchListItem(book.volumeInfoDto ?: VolumeInfo.empty())
                    HorizontalDivider()
                }
            }
        }
    }
}