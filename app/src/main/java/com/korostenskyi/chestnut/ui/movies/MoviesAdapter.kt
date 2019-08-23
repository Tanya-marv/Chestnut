package com.korostenskyi.chestnut.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.korostenskyi.chestnut.R
import com.korostenskyi.domain.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter(private val movies: MutableList<Movie>, private val seeMoreClickListener: ((movie: Movie) -> Unit)? = null): RecyclerView.Adapter<MoviesViewHolder>() {

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) = holder.bind(movies[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val movieRow = layoutInflater.inflate(R.layout.item_movie, parent, false)
        return MoviesViewHolder(movieRow, seeMoreClickListener)
    }

    fun addMovieList(movieList: List<Movie>) {
        movies.addAll(movieList)
        notifyDataSetChanged()
    }
}

class MoviesViewHolder(private val view: View, private val seeMoreClickListener: ((movie: Movie) -> Unit)? = null): RecyclerView.ViewHolder(view) {

    fun bind(movie: Movie) {
        view.apply {
            ivMoviePoster.load("$POSTER_BASE_URL${movie.posterPath}") {
                placeholder(R.drawable.ic_launcher_background)
                transformations(RoundedCornersTransformation(20f))
                crossfade(true)
            }
            setOnClickListener { seeMoreClickListener?.invoke(movie) }
        }
    }

    companion object {
        const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500/"
    }
}