package com.rodrigonovoa.domain.usecase

import com.rodrigonovoa.domain.model.BookDetail
import com.rodrigonovoa.domain.repository.BookShelfRepository

class SaveBookUseCase(private val repository: BookShelfRepository) {
    suspend operator fun invoke(book: BookDetail){
        repository.save(book)
    }
}