package com.rodrigonovoa.pocketbookshelf.di

import com.rodrigonovoa.data.remote.booksApi.api.GoogleBooksApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val networkModule = module {
    single {
        loggingInterceptor
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<GoogleBooksApi> {
        get<Retrofit>().create(GoogleBooksApi::class.java)
    }
}
