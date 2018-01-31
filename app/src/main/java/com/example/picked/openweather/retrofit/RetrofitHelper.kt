package com.example.picked.openweather.retrofit

import com.example.picked.openweather.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


fun <T> createApi(clazz: Class<T>): T {
    val rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()
    val gsonConverterFactory = GsonConverterFactory.create()
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .client(getClient())
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .addConverterFactory(gsonConverterFactory)
            .build().create(clazz)
}

private fun getClient(): OkHttpClient? {
    val logging = HttpLoggingInterceptor()
    logging.level = BODY
    val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    return client
}