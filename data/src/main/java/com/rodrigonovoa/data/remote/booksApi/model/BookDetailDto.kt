package com.rodrigonovoa.data.remote.booksApi.model

import com.rodrigonovoa.domain.model.BookDetail

data class BookDetailDto(
    val id: String,
    val volumeInfo: VolumeInfoDto,
    val publisher: String?,
    val publishedDate: String?,
    val description: String?,
    val pageCount: Int
) {
    fun toDomain(): BookDetail {
        return BookDetail(
            id,
            volumeInfo.toDomain(),
            publisher,
            publishedDate,
            description,
            pageCount
        )
    }
}