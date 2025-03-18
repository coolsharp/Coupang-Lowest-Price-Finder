package com.coolsharp.coupang.data.network

import io.nerdythings.okhttp.profiler.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import io.nerdythings.okhttp.profiler.OkHttpProfilerInterceptor

object RetrofitHelper {
    private const val BASE_URL = "https://dummyjson.com/"

    fun getInstance(): Retrofit {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(OkHttpProfilerInterceptor())
        }
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(builder.build())
            .build()
    }
}