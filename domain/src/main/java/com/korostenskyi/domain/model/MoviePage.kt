package com.korostenskyi.domain.model

data class MoviePage (
    val pageNumber: Int,
    val movies: List<Movie>,
    val totalPagesAmount: Int?,
    val totalMoviesAmount: Int?
)