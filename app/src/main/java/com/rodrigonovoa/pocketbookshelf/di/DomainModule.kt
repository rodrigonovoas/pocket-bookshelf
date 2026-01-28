package com.rodrigonovoa.pocketbookshelf.di

import com.rodrigonovoa.domain.usecase.GetBooksUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetBooksUseCase(
            googleBooksRepository = get()
        )
    }
}
