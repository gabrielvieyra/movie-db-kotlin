package com.example.movie_db_kotlin.core.domain.model

data class Movie(
    val description: String = "",
    val title: String = "",
    val id: Int = 0, // Tipo entero
    val releaseYear: Int = 2000,
    val language: String = "",
    val rating: Double = 7.5, // Tipo decimal
    val image: String = "",
    val genres: List<Int> = emptyList() // Tipo array de enteros
)





