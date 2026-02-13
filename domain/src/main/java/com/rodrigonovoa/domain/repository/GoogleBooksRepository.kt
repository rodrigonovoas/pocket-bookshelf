package com.rodrigonovoa.domain.repository

import com.rodrigonovoa.domain.model.BooksList
import kotlinx.coroutines.flow.Flow

interface GoogleBooksRepository {
    suspend fun searchBooks(query: String): Flow<BooksList>
}