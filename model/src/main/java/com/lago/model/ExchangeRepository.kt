package com.lago.model

import kotlinx.coroutines.flow.Flow

interface ExchangeRepository {

    fun getExchange(): Flow<Exchange>
}
