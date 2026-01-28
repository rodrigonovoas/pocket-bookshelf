package com.rodrigonovoa.domain.repository

import com.rodrigonovoa.domain.model.BooksList

interface GoogleBooksRepository {
    suspend fun getBooks(): BooksList
}