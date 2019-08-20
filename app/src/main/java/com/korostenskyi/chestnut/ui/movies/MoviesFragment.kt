package com.korostenskyi.chestnut.ui.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.korostenskyi.chestnut.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {

    private val viewModel: MoviesViewModel by viewModel()
    private val adapter by lazy {
        MoviesAdapter(mutableListOf()) {
            // TODO: Navigate to details screen
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUi()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.fetchMovieRecommendations(550)
    }

    private fun bindUi() {
        viewModel.moviesLiveData.observe(this, Observer { movies ->
            Log.d("MoviesFragment", "$movies")
        })
    }
}
