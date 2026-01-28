package com.rodrigonovoa.ui.screens.searchScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigonovoa.domain.usecase.GetBooksUseCase
import kotlinx.coroutines.launch

class SearchScreenViewModel(
    private val getBooksUseCase: GetBooksUseCase
): ViewModel() {

    fun getBooks() {
        viewModelScope.launch {
            val books = getBooksUseCase()
            print(books)
        }
    }
}