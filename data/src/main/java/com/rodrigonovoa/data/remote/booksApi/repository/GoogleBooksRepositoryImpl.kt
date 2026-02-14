package com.rodrigonovoa.data.remote.booksApi.repository

import com.rodrigonovoa.data.remote.booksApi.api.GoogleBooksApi
import com.rodrigonovoa.domain.model.BooksList
import com.rodrigonovoa.domain.repository.GoogleBooksRepository

class GoogleBooksRepositoryImpl(
    private val api: GoogleBooksApi
): GoogleBooksRepository {
        override suspend fun searchBooks(query: String): BooksList {
            return api.searchBooks(query).toDomain()
    }
}