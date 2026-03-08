package com.rodrigonovoa.ui.screens.searchScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.rodrigonovoa.domain.repository.Resource

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun SearchScreen(
    viewModel: SearchScreenViewModel,
    navController: NavHostController
) {
    val books by viewModel.booksState.collectAsStateWithLifecycle()
    val booksQuery by viewModel.searchQuery.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Search",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = (-0.5).sp
        )

        Spacer(modifier = Modifier.height(28.dp))

        TextField(
            value = booksQuery,
            onValueChange = { viewModel.onSearchChanged(it) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Search your book") }
        )

        Spacer(modifier = Modifier.height(4.dp))

        when (val state = viewModel.booksState.value) {
            is Resource.Loading -> LoadingState()
            is Resource.Error   -> ErrorMessage()
            is Resource.Success -> {
                LazyColumn {
                    items(
                        items = state.data,
                        key = { book -> book.id }
                    ) { book ->
                        SearchListItem(
                            book,
                            onItemClicked = { bookId ->
                                navController.navigate("detail/${bookId}")
                            }
                        )

                        Spacer(modifier = Modifier.height(8.dp))
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