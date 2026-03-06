package com.rodrigonovoa.data.remote.booksApi.repository.remote

import com.rodrigonovoa.data.remote.booksApi.api.GoogleBooksApi
import com.rodrigonovoa.domain.model.BookDetail
import com.rodrigonovoa.domain.model.BooksList
import com.rodrigonovoa.domain.repository.GoogleBooksRepository

class GoogleBooksRepositoryImpl(
    private val api: GoogleBooksApi
): GoogleBooksRepository {
        override suspend fun searchBooks(query: String): BooksList {
            return api.searchBooks(query).toDomain()
    }

    override suspend fun getBookDetail(bookId: String): BookDetail {
        return api.bookDetail(bookId).toDomain()
    }
}