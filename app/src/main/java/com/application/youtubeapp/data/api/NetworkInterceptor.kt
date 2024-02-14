package com.application.youtubeapp.data.api

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Named

class NetworkInterceptor @Inject constructor(private val apiKey: String): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().url.newBuilder()
        request.addQueryParameter(name = "key", value = apiKey)
        return chain.proceed(chain.request().newBuilder().url(request.build()).build())
    }
}
