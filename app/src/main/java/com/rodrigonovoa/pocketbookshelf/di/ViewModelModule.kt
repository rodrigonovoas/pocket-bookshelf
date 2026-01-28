package com.rodrigonovoa.pocketbookshelf.di

import com.rodrigonovoa.ui.screens.searchScreen.SearchScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        SearchScreenViewModel(
            getBooksUseCase = get()
        )
    }
}
