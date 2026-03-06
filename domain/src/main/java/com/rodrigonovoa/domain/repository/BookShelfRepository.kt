package com.rodrigonovoa.domain.repository

import com.rodrigonovoa.domain.model.Book
import com.rodrigonovoa.domain.model.BookDetail

interface BookShelfRepository {
    suspend fun getAll(): List<Book>
    suspend fun save(bookDetail: BookDetail)
    suspend fun delete(id: Long)
}