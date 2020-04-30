package com.lago.api

import android.content.Context
import com.lago.api.OkHttpInterceptor.createOkHttpInterceptor
import com.lago.api.OkHttpInterceptor.createOkHttpNetworkInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient

@Module(includes = [ApiModule.Providers::class])
internal class ApiModule {

    @Module
    internal object Providers {

        @Provides
        fun provideOkHttpClient(
            context: Context
        ): OkHttpClient = OkHttpClient.Builder()
            .cache(Cache(context.cacheDir, 1 * 1024 * 1024)) // 1 MB
            .addInterceptor(createOkHttpInterceptor())
            .addNetworkInterceptor(createOkHttpNetworkInterceptor())
            .addNetworkDebuggingInterceptor()
            .build()
    }
}
