package com.example.newsapiandroid4.data

import com.example.newsapiandroid4.data.interseptors.ApiKeyinterseptor
import com.example.newsapiandroid4.data.models.Source
import com.example.newsapiandroid4.data.remote.apiservices.EverythingApiService
import com.example.newsapiandroid4.data.remote.apiservices.TopHeadlinesApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private val okkHttClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(ApiKeyinterseptor())
        .addInterceptor(provideLoggingInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .client(okkHttClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BODY
    )

    fun provideEverythingNews() =
        retrofitClient.create(EverythingApiService::class.java)

    fun provideTopHeadlinesNews() =
        retrofitClient.create(TopHeadlinesApiService::class.java)

    fun provideSources() =
        retrofitClient.create(Source::class.java)
}
