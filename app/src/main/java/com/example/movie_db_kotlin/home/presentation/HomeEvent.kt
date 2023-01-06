package com.example.movie_db_kotlin.home.presentation

sealed class HomeEvent {
    data class ChangeFilter(val filterType: FilterType): HomeEvent()
    data class onMovieClick(val movieId: Int): HomeEvent()
}