package com.example.amphibiansapp.network

import com.example.amphibiansapp.model.Amphibians
import retrofit2.http.GET

interface AmphibiansApiService {
    @GET("amphibians")
    suspend fun getData(): List<Amphibians>
}