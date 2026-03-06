package com.rodrigonovoa.data.remote.booksApi.repository.local.db

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromAuthors(authors: List<String>): String {
        return authors.joinToString(",")
    }

    @TypeConverter
    fun toAuthors(data: String): List<String> {
        return if (data.isEmpty()) emptyList() else data.split(",")
    }
}