package com.rodrigonovoa.ui.screens.searchScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rodrigonovoa.domain.model.VolumeInfo
import com.rodrigonovoa.domain.repository.Resource

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun SearchScreen(
    viewModel: SearchScreenViewModel
) {
    val books by viewModel.booksState.collectAsStateWithLifecycle()
    val booksQuery by viewModel.searchQuery.collectAsStateWithLifecycle()

    Column {
        TextField(
            value = booksQuery,
            onValueChange = { viewModel.onSearchChanged(it) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Search your book") }
        )

        when (val state = viewModel.booksState.value) {
            is Resource.Loading -> LoadingState()
            is Resource.Error   -> ErrorMessage()
            is Resource.Success -> {
                LazyColumn {
                    items(
                        items = state.data,
                        key = { book -> book.id }
                    ) { book ->
                        if (book.volumeInfoDto != null) {
                            SearchListItem(book.volumeInfoDto ?: VolumeInfo.empty())
                            HorizontalDivider()
                        }
                    }
                }
            }
            null -> {  }
        }
    }
}

@Composable
private fun LoadingState() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ErrorMessage() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Error retrieving data.")
    }
}