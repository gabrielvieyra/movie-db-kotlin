package com.example.movie_db_kotlin.core.domain.model

data class Movie(
    val description: String,
    val title: String,
    val id: Int, // Tipo entero
    val releaseYear: Int,
    val language: String,
    val rating: Double, // Tipo decimal
    val image: String,
    val genres: List<Int> // Tipo array de enteros
)





