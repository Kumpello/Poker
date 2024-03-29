package com.kumpello.poker.data.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val tempBaseUrl = "http://192.168.0.146:8080"

    val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(RequestInterceptor)
        .build()

    fun getClient(): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(tempBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}