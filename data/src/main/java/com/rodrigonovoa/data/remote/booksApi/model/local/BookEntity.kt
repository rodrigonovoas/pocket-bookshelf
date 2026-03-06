package com.rodrigonovoa.data.remote.booksApi.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "book")
data class BookEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val authors: List<String>
)