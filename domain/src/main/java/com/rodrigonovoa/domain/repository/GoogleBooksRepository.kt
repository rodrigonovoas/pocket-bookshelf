package com.rodrigonovoa.domain.repository

import com.rodrigonovoa.domain.model.BookDetail
import com.rodrigonovoa.domain.model.BooksList

interface GoogleBooksRepository {
    suspend fun searchBooks(query: String): BooksList
    suspend fun getBookDetail(bookId: String): BookDetail
}