package com.rodrigonovoa.data.remote.booksApi.model.remote

import com.rodrigonovoa.domain.model.VolumeInfo

data class VolumeInfoDto(
    val title: String,
    val authors: List<String>?
) {
    fun toDomain(): VolumeInfo {
        return VolumeInfo(title, authors)
    }
}