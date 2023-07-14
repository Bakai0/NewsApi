package com.example.newsapiandroid4.data.remote.apiservices

import com.example.newsapiandroid4.data.models.NewsModel
import com.example.newsapiandroid4.data.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface SourcesApiService {

    @GET("top-headlines/sources")
    suspend fun fetchSourcesNews(
    ): Response<NewsResponse<NewsModel>>
}