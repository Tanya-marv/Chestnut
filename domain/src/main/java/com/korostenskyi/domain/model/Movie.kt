package com.korostenskyi.domain.model

data class Movie (
    val posterPath: String?,
    val isAdult: Boolean?,
    val overview: String?,
    val releaseDate: String?,
    val genres: List<Int>?,
    val id: Int,
    val originalTitle: String?,
    val originalLanguage: String?,
    val title: String?,
    val backdropPath: String?,
    val popularity: Double?,
    val voteCount: Int?,
    val isVideo: Boolean?,
    val voteAverage: Double?
)