package com.example.myapplication.data.remote

import com.example.myapplication.data.entities.remote.MovieApi
import com.example.myapplication.data.entities.remote.MovieTopApi
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    companion object {
        private const val apiKey = "389ab18e8c7ba5c6ac629e72f354954c"
    }

    @GET("movie/{id}?api_key=$apiKey&language=ru")
    suspend fun getMovie(@Path("id") id: Int): MovieApi

    @GET("movie/top_rated?api_key=$apiKey&language=ru")
    suspend fun getTop(@Query("page") page: Int): MovieTopApi

}