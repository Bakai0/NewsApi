package com.example.newsapiandroid4.data.remote.apiservices

import com.example.newsapiandroid4.data.models.NewsModel
import com.example.newsapiandroid4.data.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EverythingApiService {

    @GET("everything")
    suspend fun fetchEverythingBitcoinNews(
        @Query("q") bitcoinNews: String = "+bitcoin",
    ): Response<NewsResponse<NewsModel>>
}