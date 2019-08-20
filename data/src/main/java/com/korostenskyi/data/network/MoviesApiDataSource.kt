package com.korostenskyi.data.network

import com.korostenskyi.data.model.MovieResponse

interface MoviesApiDataSource {

    suspend fun fetchMovieRecommendations(movieId: Int): List<MovieResponse>
}