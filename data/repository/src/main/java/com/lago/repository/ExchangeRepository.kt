package com.lago.repository

import com.lago.api.ExchangeService
import com.lago.model.Exchange
import com.lago.model.IExchangeRepository
import com.lago.repository.mapper.toExchange
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class ExchangeRepository(
    private val exchangeService: ExchangeService
) : IExchangeRepository {

    override fun getExchange(): Flow<Exchange> {
        return flow { emit(exchangeService.getExchange().toExchange()) }.flowOn(Dispatchers.IO)
    }
}
