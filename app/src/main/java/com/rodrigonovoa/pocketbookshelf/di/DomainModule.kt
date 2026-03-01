package com.rodrigonovoa.pocketbookshelf.di

import com.rodrigonovoa.domain.usecase.GetBookDetailUseCase
import com.rodrigonovoa.domain.usecase.SearchBooksUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        SearchBooksUseCase(
            googleBooksRepository = get()
        )
    }

    factory {
        GetBookDetailUseCase(
            googleBooksRepository = get()
        )
    }
}
