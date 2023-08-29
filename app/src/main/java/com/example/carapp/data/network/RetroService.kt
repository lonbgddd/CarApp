package com.example.carapp.data.network

import com.example.carapp.data.model.Recorder
import com.example.carapp.ui.model.Car
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetroService {
    @GET("post")
    @Headers("Accept:application/json", "Content-Type:application/json")
    suspend fun getPostList(): Flow<List<Recorder>>
}