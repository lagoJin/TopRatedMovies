package com.lago.repository

import com.lago.api.ExchangeService
import com.lago.model.IExchangeRepository
import dagger.Module
import dagger.Provides

@Module(includes = [RepositoryModule.Providers::class])
internal class RepositoryModule {

    @Provides
    fun exchangeRepository(
        exchangeService: ExchangeService
    ): IExchangeRepository {
        return ExchangeRepository(exchangeService)
    }

    @Module
    internal object Providers
}
