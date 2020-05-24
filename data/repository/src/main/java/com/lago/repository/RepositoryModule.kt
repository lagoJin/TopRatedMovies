package com.lago.repository

import com.lago.api.MovieService
import com.lago.model.IMovieRepository
import dagger.Module
import dagger.Provides

@Module(includes = [RepositoryModule.Providers::class])
internal class RepositoryModule {

    @Provides
    fun exchangeRepository(
        movieService: MovieService
    ): IMovieRepository {
        return MovieRepository(movieService)
    }

    @Module
    internal object Providers
}
