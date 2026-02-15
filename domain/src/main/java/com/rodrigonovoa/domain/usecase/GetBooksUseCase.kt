package com.rodrigonovoa.domain.usecase

import com.rodrigonovoa.domain.model.Book
import com.rodrigonovoa.domain.repository.GoogleBooksRepository
import com.rodrigonovoa.domain.repository.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetBooksUseCase(
    private val googleBooksRepository: GoogleBooksRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<Book>>> = flow {
        emit(Resource.Loading())
        try {
            val result = googleBooksRepository.searchBooks(query)
            emit(Resource.Success(result.items))
        } catch (e: HttpException) {
            emit(Resource.Error("Error HTTP: ${e.message()}", e.code()))
        } catch (e: IOException) {
            emit(Resource.Error("No internet connection."))
        }
    }
}