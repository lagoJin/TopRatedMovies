package com.lago.repository.mapper

import com.lago.api.response.MovieResponse
import com.lago.api.response.TopRatedMoviesResponse
import com.lago.model.Movie
import com.lago.model.TopRatedMovies

internal fun TopRatedMoviesResponse.toTopRatedMovies() = TopRatedMovies(
    page = page,
    totalResults = totalResults,
    totalPages = totalPages,
    results = results.map {
        it.toMovie()
    }
)

internal fun MovieResponse.toMovie() = Movie(
    popularity,
    voteCount,
    video,
    posterPath,
    id,
    adult,
    backdropPath,
    originalLanguage,
    originalTitle,
    genreIds,
    title,
    voteAverage,
    overView,
    releaseDate
)
