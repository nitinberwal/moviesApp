package com.example.moviesapp.di

import com.example.moviesapp.data.MoviesApi
import com.example.moviesapp.domain.MoviesRepository
import com.example.moviesapp.presentation.MoviewsViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val myModule = module {
    single { OkHttpClient() }
    single { provideMoviesApi(get()) }
    single { MoviesRepository(get()) }
    viewModel { MoviewsViewModel(get()) } // Replace MyService() with your actual implementation of the service
    }

fun provideMoviesApi(okHttpClient: OkHttpClient):MoviesApi{
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.omdbapi.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
//            .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()

    val service:MoviesApi = retrofit.create(MoviesApi::class.java)
    return service
}