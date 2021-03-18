package com.example.myapplication.data.entities.local

data class MovieTopModel(
    val results: List<ResultModel>
)

data class ResultModel(
    val title: String
)