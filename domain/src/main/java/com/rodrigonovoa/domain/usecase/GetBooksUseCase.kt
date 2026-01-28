package com.rodrigonovoa.domain.usecase

import com.rodrigonovoa.domain.model.BooksList
import com.rodrigonovoa.domain.repository.GoogleBooksRepository

class GetBooksUseCase(
    private val googleBooksRepository: GoogleBooksRepository
) {

    suspend operator fun invoke(): BooksList {
        return googleBooksRepository.getBooks()
    }
}