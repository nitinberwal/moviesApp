package com.example.moviesapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.data.MoviesUtility.MovieDetails
import com.example.moviesapp.databinding.FragmentMovieDetailsBinding
import com.example.moviesapp.presentation.MoviewsViewModel
import org.koin.android.ext.android.inject


class MovieDetailsFragment : Fragment() {
    private val moviewsViewModel: MoviewsViewModel by inject()
    private lateinit var binding:FragmentMovieDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieDetailsBinding.inflate(inflater)
        return binding.root
//        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imdbId = arguments?.getString("imdb")
        moviewsViewModel.getMovieDetails(imdbId)
        initObserver()
    }

    private fun initObserver(){
        moviewsViewModel.liveDataMovieDetail.observe(viewLifecycleOwner, movieDetailsObserver)
    }

    private val movieDetailsObserver = Observer<MovieDetails?>{
        Log.d("nitin", "title" + it?.Title?.toString())
        binding.apply {
            title.text = it?.Title

//            Glide.with(requireContext())
//                .load(it.poster)
//                .into(it)
        }
    }

}