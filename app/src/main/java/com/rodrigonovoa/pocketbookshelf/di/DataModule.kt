package com.rodrigonovoa.pocketbookshelf.di

import com.rodrigonovoa.data.remote.booksApi.repository.GoogleBooksRepositoryImpl
import com.rodrigonovoa.domain.repository.GoogleBooksRepository
import org.koin.dsl.module

val dataModule = module {
    single<GoogleBooksRepository> {
        GoogleBooksRepositoryImpl(
            api = get()
        )
    }
}
