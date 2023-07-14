package com.example.newsapiandroid4.data.remote.apiservices

import com.example.newsapiandroid4.data.models.NewsModel
import com.example.newsapiandroid4.data.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesApiService {

    @GET("top-headlines")
    suspend fun fetchTopHeadLinesNews(
        @Query("country") topHeadlines: String = "us"
    ): Response<NewsResponse<NewsModel>>
}