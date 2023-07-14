package com.example.newsapiandroid4.data.repositories

import com.example.newsapiandroid4.base.BaseRepository
import com.example.newsapiandroid4.data.remote.apiservices.EverythingApiService
import com.example.newsapiandroid4.data.remote.apiservices.SourcesApiService
import javax.inject.Inject

class SourceRepository @Inject constructor(
    private val service: SourcesApiService
): BaseRepository()  {

    fun fetchSourcesNews() = doRequest {
        service.fetchSourcesNews()
    }
}