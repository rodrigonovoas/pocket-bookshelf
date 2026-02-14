package com.rodrigonovoa.domain.repository

import com.rodrigonovoa.domain.model.BooksList

interface GoogleBooksRepository {
    suspend fun searchBooks(query: String): BooksList
}