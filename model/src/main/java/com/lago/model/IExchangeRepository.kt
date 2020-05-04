package com.lago.model

import kotlinx.coroutines.flow.Flow

interface IExchangeRepository {

    fun getExchange(): Flow<Exchange>
}
