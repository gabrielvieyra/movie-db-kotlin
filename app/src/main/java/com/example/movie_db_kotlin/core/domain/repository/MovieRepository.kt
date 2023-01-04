package com.example.movie_db_kotlin.core.domain.repository

import com.example.movie_db_kotlin.core.domain.model.Movie

interface MovieRepository {
    // En este caso este metodo va a devolver un listado de peliculas que se van a estrenar proximamente pero en otro formato
    suspend fun getUpcomingMovies(): List<Movie>
}