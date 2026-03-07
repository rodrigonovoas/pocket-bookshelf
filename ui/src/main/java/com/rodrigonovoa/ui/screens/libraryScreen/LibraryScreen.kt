package com.rodrigonovoa.ui.screens.libraryScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.rodrigonovoa.domain.model.Book

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun LibraryScreen(
    viewModel: LibraryScreenViewModel,
    navController: NavHostController
) {
    val books by viewModel.uiState.collectAsStateWithLifecycle()

    Column {
        Text("BOOKSHELF")
        BookListItem(books)
    }
}

@Composable
fun BookListItem(books: List<Book>?) {
    LazyColumn(
        modifier = Modifier.padding(top = 8.dp)
    )
    {
        items(
            items = books ?: listOf(),
            key = { book -> book.id }
        ) { book ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp)
                    .clickable { },
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = book.volumeInfo?.title ?: "",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    if (book.volumeInfo?.authors?.isNotEmpty() == true) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = book.volumeInfo?.authors?.joinToString(", ") ?: "",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            if ((books?.size ?: 0) > 1) {
                HorizontalDivider()
            }
        }
    }
}