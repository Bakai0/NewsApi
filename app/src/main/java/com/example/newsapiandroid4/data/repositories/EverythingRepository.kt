package com.example.newsapiandroid4.data.repositories

import com.example.newsapiandroid4.base.BaseRepository
import com.example.newsapiandroid4.data.remote.apiservices.EverythingApiService
import javax.inject.Inject

class EverythingRepository @Inject constructor(
    private val service: EverythingApiService
) : BaseRepository(){

    fun fetchEverythingBitcoinNews() = doRequest {
        service.fetchEverythingBitcoinNews()
    }
}