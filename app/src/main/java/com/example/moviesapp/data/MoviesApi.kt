package com.example.moviesapp.data

import android.net.Uri
import com.example.moviesapp.data.MoviesUtility.MovieDetails
import com.example.moviesapp.data.MoviesUtility.MoviesData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MoviesApi {

    @GET
    suspend fun getListOfMoviews(
        @Url url: Uri,
        @Query("s") s:String?,
        @Query("apikey") apikey:String?,
        @Query("page") page:Int
    ): Response<MoviesData?>?

    @GET
    suspend fun getMovieDetails(
        @Url url: Uri,
        @Query("i") i:String?,
        @Query("apikey") apikey:String?
    ): Response<MovieDetails?>?
}