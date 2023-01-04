package com.example.movie_db_kotlin.core.data.remote.dto

data class MovieDtoResponse(
    val dates: Dates,
    val page: Int,
    val results: List<MovieResult>,
    val total_pages: Int,
    val total_results: Int
)