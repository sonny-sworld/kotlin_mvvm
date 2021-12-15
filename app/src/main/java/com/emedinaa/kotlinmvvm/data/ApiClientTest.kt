package com.emedinaa.kotlinmvvm.data

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by sgao on 15/12/2021 10:05
 **/
object ApiClientTest {
    private var apiInterface:ApiInterface? = null

    fun buildService():ApiInterface {
        if (apiInterface == null) {
            synchronized(ApiInterface::class.java)
            {
                if (apiInterface == null) {
                    val builder: Retrofit.Builder = Retrofit.Builder()
                        .baseUrl("https://obscure-earth-55790.herokuapp.com")
                        .addConverterFactory(GsonConverterFactory.create())

                    val okHttpClient = OkHttpClient.Builder()

                    okHttpClient.addInterceptor(interceptor())
                    val retrofit2 = builder.client(okHttpClient.build()).build()
                    apiInterface = retrofit2.create(ApiInterface::class.java)
                }
            }
        }
        return apiInterface as ApiInterface
    }


    private fun interceptor():Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

}