package com.example.myapplication.data.entities.local

import java.math.BigDecimal

data class MovieModel(
    val title: String,
    val revenue: BigDecimal,
    val release_date: String,
    val poster_path: String,
)