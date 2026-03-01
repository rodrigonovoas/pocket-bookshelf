package com.rodrigonovoa.ui.screens.detailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigonovoa.domain.model.BookDetail
import com.rodrigonovoa.domain.repository.Resource
import com.rodrigonovoa.domain.usecase.GetBookDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class DetailScreenViewModel(
    private val getBookDetailUseCase: GetBookDetailUseCase
): ViewModel() {
    private val _uiState: MutableStateFlow<Resource<BookDetail>?> = MutableStateFlow(null)
    val uiState: StateFlow<Resource<BookDetail>?> = _uiState


    fun getBookDetail(bookId: String) {
        viewModelScope.launch {
            getBookDetailUseCase.invoke(bookId)
                .collect { state ->
                    when (state) {
                        is Resource.Error<*> -> {
                            _uiState.value = state
                        }
                        is Resource.Loading<*> -> {
                            _uiState.value = state
                        }

                        is Resource.Success<BookDetail> -> {
                            _uiState.value = state
                        }
                    }
                }
        }
    }
}