package com.siddhesh.yepl.network

import com.siddhesh.yepl.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object {

        val baseURL: String = "https://api.yelp.com/";
        var retofit: Retrofit? = null

        val client: Retrofit
            get() {
                if (retofit == null) {
                    val interceptor = HttpLoggingInterceptor()
                    if (BuildConfig.DEBUG)
                        interceptor.level = HttpLoggingInterceptor.Level.BODY
                    val client = OkHttpClient.Builder().addInterceptor(interceptor)
                        .connectTimeout(120, TimeUnit.SECONDS)
                        .writeTimeout(120, TimeUnit.SECONDS)
                        .readTimeout(120, TimeUnit.SECONDS)
                        .build()
                    retofit = Retrofit.Builder()
                        .baseUrl(baseURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .build()

                }
                return retofit!!
            }
    }

}