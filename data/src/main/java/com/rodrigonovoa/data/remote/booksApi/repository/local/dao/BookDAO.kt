package com.rodrigonovoa.data.remote.booksApi.repository.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rodrigonovoa.data.remote.booksApi.model.local.BookEntity

@Dao
interface BookDAO {
    @Query("SELECT * FROM book")
    suspend fun getAll(): List<BookEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: BookEntity)

    @Query("DELETE FROM book WHERE id = :id")
    suspend fun deleteById(id: Long)
}