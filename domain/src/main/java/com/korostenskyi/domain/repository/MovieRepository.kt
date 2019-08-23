package com.korostenskyi.domain.repository

import com.korostenskyi.domain.model.Movie

interface MovieRepository {

    suspend fun fetchMovieDiscover(): List<Movie>

    suspend fun fetchMovieRecommendations(movieId: Int): List<Movie>
}