package com.korostenskyi.data.network

import com.korostenskyi.data.network.api.ApiClient

class MoviesApiDataSourceImpl(private val client: ApiClient, private val apiKey: String): MoviesApiDataSource {

    override suspend fun fetchMovieRecommendations(movieId: Int) = client.fetchMovieRecommendations(movieId, apiKey).movies
}