package com.korostenskyi.chestnut.ui.movies

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(private val movies: List<String>, private val seeMoreClickListener: ((movie: String) -> Unit)? = null): RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

    }
}

class MoviesViewHolder(view: View): RecyclerView.ViewHolder(view) { }