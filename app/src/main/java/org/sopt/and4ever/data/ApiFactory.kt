package org.sopt.and4ever.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.sopt.and4ever.BuildConfig
import org.sopt.and4ever.data.service.DummyService
import retrofit2.Retrofit

object ApiFactory {
    private val client by lazy {
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            },
        ).build()
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(client).build()
    }

    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}

object ServicePool {
    val dummyService = ApiFactory.create<DummyService>()
}