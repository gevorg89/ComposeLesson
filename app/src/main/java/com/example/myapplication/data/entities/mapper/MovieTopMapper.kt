package com.example.myapplication.data.entities.mapper

import com.example.myapplication.data.entities.local.MovieTopModel
import com.example.myapplication.data.entities.local.ResultModel
import com.example.myapplication.data.entities.remote.MovieTopApi
import com.example.myapplication.data.entities.remote.ResultApi

object MovieTopMapper {
    fun map(movieTopApi: MovieTopApi): MovieTopModel {
        return MovieTopModel(
            results = map(movieTopApi.results.orEmpty())
        )
    }

    fun map(movieTopResultApi: ResultApi): ResultModel {
        return ResultModel(
            title = movieTopResultApi.title.orEmpty()
        )
    }

    fun map(movieTopResultApi: List<ResultApi>): List<ResultModel> {
        return movieTopResultApi.map {
            map(it)
        }
    }
}