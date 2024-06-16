package com.example.moviesapp.presentation.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.data.MoviesUtility.MoviesData
import com.example.moviesapp.data.MoviesUtility.Search


class MovieListingAdapter(private val context: Context, private val clickListener: View.OnClickListener):RecyclerView.Adapter<MovieListingAdapter.MovieViewHolder>() {
    var movieList = listOf<Search>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflator = LayoutInflater.from(context)
        return MovieViewHolder(inflator, parent, context, clickListener)
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun refreshMoviesList(movieList:MoviesData){
        this.movieList = movieList.search
        notifyDataSetChanged()
    }

    class MovieViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        private val context: Context,
        private val clickListener: View.OnClickListener
    ) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_movies_lists, parent, false)) {
        private var mTitleView: TextView? = null
        private var mYearView: TextView? = null
        private var movieImageView: ImageView? = null
        private var parentView:ConstraintLayout? = null

        init {
            mTitleView = itemView.findViewById(R.id.tvTitle)
            mYearView = itemView.findViewById(R.id.tvPostedDate)
            movieImageView = itemView.findViewById(R.id.ivMovies)
            parentView = itemView.findViewById<ConstraintLayout>(R.id.parent)
            parentView?.setOnClickListener(clickListener)
        }

        fun bind(movie: Search) {
            mTitleView?.text = movie.title
            mYearView?.text = movie.year.toString()
            movieImageView?.let {
                Glide.with(context)
                    .load(movie.poster)
                    .into(it)
            }
            parentView?.setTag(com.google.android.material.R.id.selection_type, movie.imdbID)
        }
    }
}