package com.korostenskyi.data.utils

import com.korostenskyi.data.model.MoviePageResponse
import com.korostenskyi.data.model.MovieResponse
import com.korostenskyi.domain.model.Movie
import com.korostenskyi.domain.model.MoviePage

fun MovieResponse.toMovie() = Movie(
    posterPath = posterPath,
    isAdult = isAdult,
    overview = overview,
    releaseDate = releaseDate,
    genres = genres,
    id = id,
    originalTitle = originalTitle,
    originalLanguage = originalLanguage,
    title = title,
    backdropPath = backdropPath,
    popularity = popularity,
    voteAverage = voteAverage,
    voteCount = voteCount,
    isVideo = isVideo
)

fun MoviePageResponse.toMoviePage() = MoviePage(
    pageNumber = pageNumber,
    movies = movies?.map { it.toMovie() },
    totalMoviesAmount = totalMoviesAmount,
    totalPagesAmount = totalPagesAmount
)