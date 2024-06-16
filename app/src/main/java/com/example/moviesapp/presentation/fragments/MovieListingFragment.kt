package com.example.moviesapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.R
import com.example.moviesapp.data.MoviesUtility.MoviesData
import com.example.moviesapp.databinding.FragmentMovieListingPageBinding
import com.example.moviesapp.presentation.MoviewsViewModel
import com.example.moviesapp.presentation.adapters.MovieListingAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListingFragment : Fragment() {

    private lateinit var binding:FragmentMovieListingPageBinding
    private val moviewsViewModel:MoviewsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieListingPageBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvMovies.adapter = MovieListingAdapter(requireContext(), clickListener = clickListener)


        initLiveDataObserver()
            moviewsViewModel.getListOfMovies(null)
    }

    private val clickListener = View.OnClickListener {
        when(it.id){
            R.id.parent -> {
                val imdbId = it.getTag(com.google.android.material.R.id.selection_type)
                findNavController().navigate(R.id.movieDetailsFragment, bundleOf("imdb" to imdbId))
            }
        }
    }

    private fun initLiveDataObserver(){
        moviewsViewModel.liveDataMovieList.observe(viewLifecycleOwner, moviesObserver)
    }

    private val moviesObserver = Observer<MoviesData>{moviesData ->
        (binding.rvMovies.adapter as? MovieListingAdapter)?.let{
            it.refreshMoviesList(moviesData)
        }
    }

}