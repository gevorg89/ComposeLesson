package com.example.myapplication

import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getMovie(id: Long) = apiService.getMovie(id)
}