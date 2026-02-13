package com.rodrigonovoa.data.remote.booksApi.repository

import com.rodrigonovoa.data.remote.booksApi.api.GoogleBooksApi
import com.rodrigonovoa.domain.model.BooksList
import com.rodrigonovoa.domain.repository.GoogleBooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GoogleBooksRepositoryImpl(
    private val api: GoogleBooksApi
): GoogleBooksRepository {
        override suspend fun searchBooks(query: String): Flow<BooksList> = flow {
            emit(api.searchBooks(query).toDomain())
    }
}