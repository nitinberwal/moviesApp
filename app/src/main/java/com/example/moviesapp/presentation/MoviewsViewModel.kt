package com.example.moviesapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.MoviesUtility.MovieDetails
import com.example.moviesapp.data.MoviesUtility.MoviesData
import com.example.moviesapp.domain.MoviesRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MoviewsViewModel(private val movieRepo:MoviesRepository):ViewModel() {

    val liveDataMovieList:MutableLiveData<MoviesData> = MutableLiveData<MoviesData>()
    val liveDataMovieDetail:MutableLiveData<MovieDetails?> = MutableLiveData<MovieDetails?>()

    fun getListOfMovies(searchQuery:String?){
        viewModelScope.launch {
            liveDataMovieList.postValue((movieRepo.getListOfMovies(searchQuery = searchQuery) as Response<MoviesData?>?)?.body() as? MoviesData)
        }
    }

    fun getMovieDetails(imdb:String?){
        viewModelScope.launch {
            liveDataMovieDetail.postValue((movieRepo.getMovieDetail(imdb = imdb))?.body())
        }
    }

}