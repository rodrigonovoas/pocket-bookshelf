package com.rodrigonovoa.domain.model

data class VolumeInfo(
    val title: String,
    val authors: List<String>? = emptyList(),
) {
    companion object {
        fun empty() = VolumeInfo("", null)
    }
}