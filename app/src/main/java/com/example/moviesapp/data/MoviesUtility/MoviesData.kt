package com.example.moviesapp.data.MoviesUtility

import com.google.gson.annotations.SerializedName

data class MoviesData(
    @SerializedName("Response") val response: String,
    @SerializedName("Search") val search: List<Search>,
    @SerializedName("totalResults") val totalResults: String
)


