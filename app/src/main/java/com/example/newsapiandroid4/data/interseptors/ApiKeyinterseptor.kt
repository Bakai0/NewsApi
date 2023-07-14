package com.example.newsapiandroid4.data.interseptors

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyinterseptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("apiKey","1bbf55c3e3fc4d77bea296810051667c").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}