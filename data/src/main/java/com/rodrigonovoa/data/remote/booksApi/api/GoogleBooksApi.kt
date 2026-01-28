package com.rodrigonovoa.data.remote.booksApi.api

import com.rodrigonovoa.data.remote.booksApi.model.BooksListDto
import com.rodrigonovoa.pocketbookshelf.data.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query


interface GoogleBooksApi {
    // @GET("volumes?q=flowers+inauthor:keyes&key=AIzaSyCDzz06ChcST4PCzvmKmE653eXkDirDZ1M")
    @GET("volumes")
    suspend fun getBooks(
        @Query("q") query: String = "flowers+inauthor:keyes",
        @Query("key") apiKey: String = BuildConfig.GOOGLE_BOOKS_API_KEY
    ): BooksListDto
}
