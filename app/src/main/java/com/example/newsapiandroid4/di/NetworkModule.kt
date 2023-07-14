package com.example.newsapiandroid4.di

import com.example.newsapiandroid4.data.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

    @Module
    @InstallIn(SingletonComponent::class)
    object NetworkModule {

        @Singleton
        @Provides
        fun provideRetrofitClient() = RetrofitClient()

        @Singleton
        @Provides

        fun provideEverythingNews(retrofitClient: RetrofitClient) =
            retrofitClient.provideEverythingNews()

        @Singleton
        @Provides
        fun provideTopHeadlinesNews(retrofitClient: RetrofitClient) =
            retrofitClient.provideTopHeadlinesNews()

        @Singleton
        @Provides
        fun provideSorcesNews(retrofitClient: RetrofitClient) =
            retrofitClient.provideSources()

    }