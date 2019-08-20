package com.korostenskyi.domain.interactor

import com.korostenskyi.domain.model.Movie

interface MovieInteractor {

    suspend fun fetchMovieRecommendations(movieId: Int): List<Movie>
}