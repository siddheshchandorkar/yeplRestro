package com.siddhesh.yepl.network

import com.siddhesh.yepl.utils.Keys
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object {

        val baseURL: String = "https://api.yelp.com/"
        var retofit: Retrofit? = null

        val client: Retrofit
            get() {
                if (retofit == null) {
                    val interceptor = HttpLoggingInterceptor()
                    interceptor.level = HttpLoggingInterceptor.Level.BODY
                    val client = OkHttpClient.Builder()
                        .connectTimeout(120, TimeUnit.SECONDS)
                        .writeTimeout(120, TimeUnit.SECONDS)
                        .readTimeout(120, TimeUnit.SECONDS)
                        .addInterceptor(interceptor)
                        .addInterceptor(Interceptor { chain ->
                            val newRequest: Request = chain.request().newBuilder()
                                .addHeader(
                                    Keys.KEY_AUTHORIZATION,
                                    "Bearer XPFgzKwZGK1yqRxHi0d5xsARFOLpXIvccQj5jekqTnysweGyoIfVUHcH2tPfGq5Oc9kwKHPkcOjk2d1Xobn7aTjOFeop8x41IUfVvg2Y27KiINjYPADcE7Qza0RkX3Yx"
                                )
                                .build()
                            chain.proceed(newRequest)
                        })
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