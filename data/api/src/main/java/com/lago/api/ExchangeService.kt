package com.lago.api

import com.lago.api.response.ExchangeResponse
import retrofit2.http.GET

interface ExchangeService {

    @GET("exchange")
    suspend fun getExchange(): ExchangeResponse
}
