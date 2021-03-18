package com.example.myapplication.data.entities.remote

import com.google.gson.annotations.SerializedName

data class MovieTopApi(
    @SerializedName("results") val results: List<ResultApi>?
)

data class ResultApi(
    @SerializedName("title") val title: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("original_title") val originalTitle: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("id") val id: Int?
)