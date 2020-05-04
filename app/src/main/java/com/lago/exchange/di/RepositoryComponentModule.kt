package com.lago.exchange.di

import android.content.Context
import com.lago.api.ExchangeService
import com.lago.model.IExchangeRepository
import com.lago.repository.RepositoryComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryComponentModule {

    @Singleton
    @Provides
    fun provideExchangeRepository(
        repositoryComponent: RepositoryComponent
    ): IExchangeRepository {
        return repositoryComponent.exchangeRepository()
    }

    @Singleton
    @Provides
    fun provideRepositoryComponent(
        context: Context,
        exchangeService: ExchangeService
    ): RepositoryComponent {
        return RepositoryComponent.factory().create(
            context, exchangeService
        )
    }
}
