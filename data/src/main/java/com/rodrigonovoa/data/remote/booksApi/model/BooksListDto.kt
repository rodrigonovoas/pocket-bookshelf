package com.rodrigonovoa.data.remote.booksApi.model

import com.rodrigonovoa.domain.model.BooksList

data class BooksListDto(
    val items: List<BookDto>
) {
    fun toDomain(): BooksList {
        return BooksList(items.map { it.toDomain() })
    }
}