package com.rodrigonovoa.data.remote.booksApi.repository.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rodrigonovoa.data.remote.booksApi.model.local.BookEntity
import com.rodrigonovoa.data.remote.booksApi.repository.local.dao.BookDAO


@TypeConverters(Converters::class)
@Database(entities = [BookEntity::class], version = 1)
abstract class BookshelfDataBase : RoomDatabase() {
    abstract fun bookDAO(): BookDAO
}
