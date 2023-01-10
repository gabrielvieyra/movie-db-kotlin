package com.example.movie_db_kotlin.core.domain.repository

import com.example.movie_db_kotlin.core.domain.model.Movie

interface MovieRepository {
    // En este caso este metodo va a devolver un listado de peliculas que se van a estrenar proximamente pero en otro formato
    suspend fun getUpcomingMovies(): Result<List<Movie>>
    suspend fun getPopularMovies(): Result<List<Movie>>
    suspend fun getMoviesByYear(year: Int): Result<List<Movie>>
    suspend fun getMoviesByLanguage(language: String): Result<List<Movie>>
}