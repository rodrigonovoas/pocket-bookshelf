package com.rodrigonovoa.ui.screens.detailScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rodrigonovoa.domain.model.BookDetail
import com.rodrigonovoa.domain.repository.Resource

@Composable
fun DetailScreen(
    viewModel: DetailScreenViewModel,
    bookId: String?
) {
    val book by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getBookDetail(bookId ?: "")
    }

    when (val state = book) {
        is Resource.Loading -> {}
        is Resource.Error   -> {}
        is Resource.Success -> {
            DetailScreenContent(state.data) {
                viewModel.saveBook(state.data)
            }
        }
        null -> {  }
    }
}

@Composable
private fun DetailScreenContent(
    bookDetail: BookDetail,
    onSaveButtonClicked: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(bookDetail.volumeInfo.title)
            Text(bookDetail.volumeInfo.authors?.first() ?: "")
            Text(bookDetail.publisher ?: "")
            Text(bookDetail.publishedDate ?: "")
            Text(bookDetail.description ?: "")

            Button(
                onClick = { onSaveButtonClicked.invoke() }
            ) {
                Text(text = "Save book")
            }
        }
    }
}