package com.rodrigonovoa.domain.usecase


import com.rodrigonovoa.domain.model.Book
import com.rodrigonovoa.domain.repository.BookShelfRepository

class GetBooksUseCase(private val repository: BookShelfRepository) {
    suspend operator fun invoke(): List<Book>{
        return repository.getAll()
    }
}