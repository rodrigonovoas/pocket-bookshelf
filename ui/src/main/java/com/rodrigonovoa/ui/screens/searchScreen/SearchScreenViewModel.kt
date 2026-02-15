package com.rodrigonovoa.ui.screens.searchScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigonovoa.domain.model.Book
import com.rodrigonovoa.domain.repository.Resource
import com.rodrigonovoa.domain.usecase.GetBooksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn

class SearchScreenViewModel(
    private val getBooksUseCase: GetBooksUseCase
): ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    val booksState: StateFlow<Resource<List<Book>>?> =
        _searchQuery
            .debounce(400)
            .distinctUntilChanged()
            .filter { it.isNotBlank() }
            .flatMapLatest { query ->
                getBooksUseCase(query)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = null
            )

    fun onSearchChanged(query: String) {
        _searchQuery.value = query
    }
}