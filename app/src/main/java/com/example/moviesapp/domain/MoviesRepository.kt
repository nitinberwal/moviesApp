package com.example.moviesapp.domain

import androidx.core.net.toUri
import com.example.moviesapp.data.MoviesApi

class MoviesRepository(private val movieApi:MoviesApi) {

    suspend fun getListOfMovies(searchQuery:String?) =
        movieApi.getListOfMoviews("".toUri(), "jawan","939600f", 1)

    suspend fun getMovieDetail(imdb:String?) =
        movieApi.getMovieDetails("".toUri(), imdb,"939600f")
}