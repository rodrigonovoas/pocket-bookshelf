package com.rodrigonovoa.ui.screens.libraryScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigonovoa.domain.model.Book
import com.rodrigonovoa.domain.usecase.GetBooksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LibraryScreenViewModel(
    private val getBooksUseCase: GetBooksUseCase
): ViewModel() {
    private val _uiState: MutableStateFlow<List<Book>?> = MutableStateFlow(null)
    val uiState: StateFlow<List<Book>?> = _uiState

    init {
        getBooksFromDatabase()
    }

    private fun getBooksFromDatabase() {
        viewModelScope.launch {
            _uiState.value = getBooksUseCase.invoke()
        }
    }
}