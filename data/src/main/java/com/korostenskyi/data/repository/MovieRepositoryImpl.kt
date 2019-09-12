package com.korostenskyi.data.repository

import com.korostenskyi.data.network.MoviesApiDataSource
import com.korostenskyi.data.utils.toMovie
import com.korostenskyi.domain.model.Movie
import com.korostenskyi.domain.repository.MovieRepository

class MovieRepositoryImpl(private val apiDataSource: MoviesApiDataSource): MovieRepository {

    override suspend fun fetchMovieDiscover(): List<Movie> {
        return apiDataSource.fetchMovieDiscover().map { it.toMovie() }
    }

    override suspend fun fetchMovieRecommendations(movieId: Int): List<Movie> {
        return apiDataSource.fetchMovieRecommendations(movieId).map { it.toMovie() }
    }
}