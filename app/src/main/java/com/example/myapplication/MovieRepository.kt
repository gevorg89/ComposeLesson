package com.example.myapplication

import com.example.myapplication.data.entities.mapper.MovieMapper
import com.example.myapplication.data.entities.mapper.MovieTopMapper
import com.example.myapplication.data.remote.ApiService
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getTop(page: Int) = MovieTopMapper.map(apiService.getTop(page))
    suspend fun getMovie(id: Int) = MovieMapper.map(apiService.getMovie(id))
}