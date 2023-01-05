package com.example.movie_db_kotlin.home.presentation

import com.example.movie_db_kotlin.core.domain.model.Movie

data class HomeState(
    val upcomingMovies: List<Movie> = emptyList(),
    val popularMovies: List<Movie> = emptyList(),
    val isLoading: Boolean = false
    /*val trend: List<Movie> = emptyList(),
    val recommended: List<Movie> = emptyList()*/
)