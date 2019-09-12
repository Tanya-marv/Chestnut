package com.korostenskyi.data.model

import com.google.gson.annotations.SerializedName

data class MoviePageResponse (
    @SerializedName("page") val pageNumber: Int,
    @SerializedName("results") val movies: List<MovieResponse>,
    @SerializedName("total_pages") val totalPagesAmount: Int?,
    @SerializedName("total_results") val totalMoviesAmount: Int?
)