package com.example.myapplication.data.entities.local

data class MovieTopModel(
    val results: List<ResultModel>
)

data class ResultModel(
    val title: String,
    val posterPath: String,
    val originalTitle: String,
    val releaseDate: String,
    val overview: String,
    val id: Int
)