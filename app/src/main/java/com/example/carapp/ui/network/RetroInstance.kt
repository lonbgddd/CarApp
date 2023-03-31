package com.example.car.network

import com.example.car.base.API_KEY
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetroInstance {
    companion object {
        // call api
        fun getRetroInstance()  : RetroService {
            val logging = HttpLoggingInterceptor()
            logging.level = (HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)

            return Retrofit.Builder()
                .baseUrl(API_KEY)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                    //connect with Dao class
                .create(RetroService::class.java)
        }

    }
}