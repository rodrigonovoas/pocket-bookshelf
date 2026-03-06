package com.rodrigonovoa.data.remote.booksApi.repository.local.impl

import com.rodrigonovoa.data.remote.booksApi.mappers.toBookEntity
import com.rodrigonovoa.data.remote.booksApi.mappers.toDomain
import com.rodrigonovoa.data.remote.booksApi.repository.local.dao.BookDAO
import com.rodrigonovoa.domain.model.BookDetail
import com.rodrigonovoa.domain.repository.BookShelfRepository


class BookshelfRepositoryImpl(private val dao: BookDAO) : BookShelfRepository {
    override suspend fun getAll() = dao.getAll().map { it.toDomain() }
    override suspend fun save(bookDetail: BookDetail) = dao.insert(bookDetail.toBookEntity())
    override suspend fun delete(id: Long) = dao.deleteById(id)
}