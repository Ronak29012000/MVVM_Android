package com.sapphire.mvvm_android.api

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ServiceGenerator {
    companion object Factory {
        fun <S> createService(
            serviceClass: Class<S>,
            context: Context,
            urlCode: Int,
            header: Int
        ): S {
            val url: String = when (urlCode) {
                ApiConstant.BASE_URL_CONSTANT -> {
                    ApiConstant.BASE_URL
                }
                else -> {
                    ""
                }
            }
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val builder = original.newBuilder()
                when (header) {
                    ApiConstant.HEADER -> {
                        builder.header(ApiConstant.HEADER_KEY, ApiConstant.HEADER_VALUE)
                    }
                }
                builder.method(original.method, original.body)
                val request = builder.build()
                chain.proceed(request)
            }
            httpClient.connectTimeout(2, TimeUnit.MINUTES)
            httpClient.readTimeout(2, TimeUnit.MINUTES)
            val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = httpClient.addInterceptor(logging).build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .client(client)
                .build()
            return retrofit.create(serviceClass)
        }
    }
}