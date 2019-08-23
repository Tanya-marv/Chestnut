package com.korostenskyi.chestnut.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.korostenskyi.domain.interactor.MovieInteractor
import com.korostenskyi.domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MoviesViewModel(private val moviesInteractor: MovieInteractor): ViewModel() {

    val moviesLiveData = MutableLiveData<List<Movie>>()

    fun fetchMovieRecommendations(movieId: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            moviesLiveData.postValue(moviesInteractor.fetchMovieRecommendations(movieId))
        }
    }

    fun fetchMovieDiscover() {
        GlobalScope.launch(Dispatchers.IO) {
            moviesLiveData.postValue(moviesInteractor.fetchMovieDiscover())
        }
    }
}