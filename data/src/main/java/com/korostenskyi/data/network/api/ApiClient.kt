package com.korostenskyi.data.network.api

import com.korostenskyi.data.model.MoviePageResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {

    @GET("movie/{movie_id}/recommendations")
    suspend fun fetchMovieRecommendations(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): MoviePageResponse
}