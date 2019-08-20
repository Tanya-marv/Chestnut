package com.korostenskyi.domain.interactor

import com.korostenskyi.domain.repository.MovieRepository

class MovieInteractorImpl(private val repository: MovieRepository): MovieInteractor {

    override suspend fun fetchMovieRecommendations(movieId: Int) = repository.fetchMovieRecommendations(movieId)
}