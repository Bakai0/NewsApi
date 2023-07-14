package com.example.newsapiandroid4.data.repositories

import com.example.newsapiandroid4.base.BaseRepository
import com.example.newsapiandroid4.data.remote.apiservices.TopHeadlinesApiService
import javax.inject.Inject

class TopHeadlinesRepository @Inject constructor(
    private val service: TopHeadlinesApiService
): BaseRepository() {

    fun fetchTopHeadlinesNews() = doRequest {
        service.fetchTopHeadLinesNews()
    }
}