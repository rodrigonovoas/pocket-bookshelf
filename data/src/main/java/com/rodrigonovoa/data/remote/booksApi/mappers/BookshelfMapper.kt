package com.rodrigonovoa.data.remote.booksApi.mappers

import com.rodrigonovoa.data.remote.booksApi.model.local.BookEntity
import com.rodrigonovoa.domain.model.Book
import com.rodrigonovoa.domain.model.BookDetail
import com.rodrigonovoa.domain.model.VolumeInfo

fun Book.toEntity(): BookEntity {
    return BookEntity(
        title = volumeInfo?.title ?: "",
        authors =  volumeInfo?.authors ?: listOf()
    )
}

fun BookEntity.toDomain(): Book {
    return Book(
        id = id.toString(),
        volumeInfo = VolumeInfo(
            title = this.title,
            authors = this.authors
        )
    )
}

fun BookDetail.toBookEntity(): BookEntity {
    return BookEntity(
        title = volumeInfo.title,
        authors = volumeInfo.authors ?: listOf()
    )
}