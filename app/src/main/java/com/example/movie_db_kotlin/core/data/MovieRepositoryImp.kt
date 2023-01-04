package com.example.movie_db_kotlin.core.data

import com.example.movie_db_kotlin.core.data.remote.MovieApi
import com.example.movie_db_kotlin.core.data.remote.dto.MovieResult
import com.example.movie_db_kotlin.core.domain.model.Movie
import com.example.movie_db_kotlin.core.domain.repository.MovieRepository
import java.lang.Exception

// Creamos la clase repository y vamos a hacer que reciba la api
class MovieRepositoryImp(
    private val api: MovieApi
): MovieRepository {
    override suspend fun getUpcomingMovies(): List<Movie> {
        return try {
            val response = api.getUpcomingMovies().results
            // El metodo map lo que hace es recorrer todo el listado de results y que por cada uno va a llamar el metodo convert
            response.map { convert(it) }
        } catch (e:Exception) {
            emptyList()
        }
    }

    // Vamos a convertir el listado de tipo MovieResult a un listado de tipo Movie
    private fun convert(results: MovieResult) : Movie {
        return Movie(
            description = results.overview,
            title = results.title,
            id = results.id,
            releaseYear = results.release_date.substring(0, 4).toInt(),
            language = results.original_language,
            rating = results.vote_average,
            image = MovieApi.BASE_URL + results.poster_path,
            genres = results.genre_ids
        )
    }
}




















































