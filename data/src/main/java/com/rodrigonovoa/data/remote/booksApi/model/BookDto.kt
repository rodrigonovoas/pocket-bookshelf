package com.rodrigonovoa.data.remote.booksApi.model

import com.rodrigonovoa.domain.model.Book

data class BookDto(
    val id: String,
    val volumeInfo: VolumeInfoDto?
) {
    fun toDomain(): Book {
        return Book(id, volumeInfo?.toDomain())
    }
}