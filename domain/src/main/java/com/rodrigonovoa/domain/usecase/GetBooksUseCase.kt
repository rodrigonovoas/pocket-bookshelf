package com.rodrigonovoa.domain.usecase

import com.rodrigonovoa.domain.model.BooksList
import com.rodrigonovoa.domain.repository.GoogleBooksRepository
import kotlinx.coroutines.flow.Flow

class GetBooksUseCase(
    private val googleBooksRepository: GoogleBooksRepository
) {
    suspend operator fun invoke(query: String): Flow<BooksList> =
        googleBooksRepository.searchBooks(query)
}