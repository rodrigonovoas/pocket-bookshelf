package com.rodrigonovoa.pocketbookshelf.di

import androidx.room.Room
import com.rodrigonovoa.data.remote.booksApi.repository.local.dao.BookDAO
import com.rodrigonovoa.data.remote.booksApi.repository.local.db.BookshelfDataBase
import com.rodrigonovoa.data.remote.booksApi.repository.local.impl.BookshelfRepositoryImpl
import com.rodrigonovoa.domain.repository.BookShelfRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<BookshelfDataBase> {
        Room.databaseBuilder(
            androidContext(),
            BookshelfDataBase::class.java,
            "bookshelf_db"
        ).build()
    }

    single<BookDAO> {
        get<BookshelfDataBase>().bookDAO()
    }

    single<BookShelfRepository> {
        BookshelfRepositoryImpl(get())
    }
}