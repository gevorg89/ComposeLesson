package com.example.myapplication.data.entities.mapper

import com.example.myapplication.data.entities.local.MovieModel
import com.example.myapplication.data.entities.remote.MovieApi
import java.math.BigDecimal

object MovieMapper {
    fun map(movieApi: MovieApi): MovieModel {
        return MovieModel(
            title = movieApi.title.orEmpty(),
            poster_path = movieApi.poster_path.orEmpty(),
            release_date = movieApi.release_date.orEmpty(),
            revenue = movieApi.revenue ?: BigDecimal.ZERO
        )
    }
}