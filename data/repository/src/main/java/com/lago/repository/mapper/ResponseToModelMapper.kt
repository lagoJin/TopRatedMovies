package com.lago.repository.mapper

import com.lago.api.response.BelongsToCollectionResponse
import com.lago.api.response.GenreResponse
import com.lago.api.response.MovieDetailResponse
import com.lago.api.response.MovieResponse
import com.lago.api.response.ProductionCompanyResponse
import com.lago.api.response.ProductionCountryResponse
import com.lago.api.response.SpokenLanguageResponse
import com.lago.api.response.TopRatedMoviesResponse
import com.lago.model.BelongsToCollection
import com.lago.model.Genre
import com.lago.model.Movie
import com.lago.model.MovieDetail
import com.lago.model.ProductionCompany
import com.lago.model.ProductionCountry
import com.lago.model.SpokenLanguage
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

internal fun MovieDetailResponse.toMovieDetail() = MovieDetail(
    adult,
    backdropPath,
    belongsToCollection?.toBelongToCollection(),
    budget,
    genres.map { it.toGenres() },
    homepage,
    id,
    imdbId,
    originalLanguage,
    originalTitle,
    overview,
    popularity,
    posterPath,
    productionCompanies.map { it.toProductionCompany() },
    productionCountries.map { it.toProductionCountry() },
    releaseDate,
    revenue,
    runtime,
    spokenLanguages.map { it.toSpokenLanguage() },
    status,
    tagline,
    title,
    video,
    voteAverage,
    voteCount
)

internal fun BelongsToCollectionResponse.toBelongToCollection() = BelongsToCollection(
    backdropPath.orEmpty(), id, name, posterPath
)

internal fun GenreResponse.toGenres() = Genre(
    id,
    name
)

internal fun ProductionCompanyResponse.toProductionCompany() = ProductionCompany(
    id,
    logoPath.orEmpty(),
    name,
    originCountry
)

internal fun ProductionCountryResponse.toProductionCountry() = ProductionCountry(
    iso31661,
    name
)

internal fun SpokenLanguageResponse.toSpokenLanguage() = SpokenLanguage(
    iso6391,
    name
)
