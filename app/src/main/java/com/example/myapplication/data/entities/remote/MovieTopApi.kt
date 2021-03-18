package com.example.myapplication.data.entities.remote

import com.google.gson.annotations.SerializedName

data class MovieTopApi(
    @SerializedName("results") val results: List<ResultApi>?
)

data class ResultApi(
    @SerializedName("title") val title: String?
)