package com.rodrigonovoa.domain.model

data class BookDetail(
    val id: String,
    val volumeInfo: VolumeInfo,
    val publisher: String?,
    val publishedDate: String?,
    val description: String?,
    val pageCount: Int
)