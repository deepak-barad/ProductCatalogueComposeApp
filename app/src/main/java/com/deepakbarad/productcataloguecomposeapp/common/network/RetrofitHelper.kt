package com.deepakbarad.productcataloguecomposeapp.common.network

import com.deepakbarad.productcataloguecomposeapp.common.BASE_URL
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private val gson = GsonBuilder().setLenient().create()
    fun getInstance(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(AppInterceptor())
            .addInterceptor(loggingInterceptor).build()
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}

class AppInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        println(chain.request().url)
        return chain.proceed(chain.request())
    }
}