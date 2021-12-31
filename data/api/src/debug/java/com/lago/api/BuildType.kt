package com.lago.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun OkHttpClient.Builder.addNetworkDebuggingInterceptor(): OkHttpClient.Builder = this.apply {
    addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
}
