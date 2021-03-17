package com.example.myapplication

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    companion object {
        private const val apiKey = "389ab18e8c7ba5c6ac629e72f354954c"
    }

    @GET("movie/{id}?api_key=$apiKey&language=ru")
    suspend fun getMovie(@Path("id") id: Long) : Any

}