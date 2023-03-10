package com.example.movie_db_kotlin.core.data.remote

import com.example.movie_db_kotlin.core.data.remote.dto.MovieDtoResponse
import okhttp3.OkHttpClient
import org.intellij.lang.annotations.Language
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// Para hacer una pegada a la api tenemos que crear una instancia de retrofit
// Nos creamos una interfaz, usamos interfaz ya que retrofit usa interfaces
// Para llamar a MovieApi usamos repository que es algo que recomienda google
interface MovieApi {
    companion object {
        const val IMAGE_URL = "https://image.tmdb.org/t/p/original/"
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    // Al poner suspend adelante de un metodo estamos diciendo que este codigo tiene que correr si o si en corrutinas
    // Los metodos de corrutinas generalmente se van a llamar dentro de un ViewModel

    // Le avisamos a retrofit que esto es una pegada get y le pasamos el endpoint
    @GET("movie/upcoming")
    // Este metodo va a retornar un listado de peliculas que se van a estrenar proximamente
    suspend fun getUpcomingMovies(): MovieDtoResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(): MovieDtoResponse

    @GET("discover/movie?sort_by=popularity.desc&include_adult=false")
    suspend fun getMoviesByYear(@Query("year") year: Int): MovieDtoResponse

    @GET("discover/movie?sort_by=popularity.desc&include_adult=false")
    suspend fun getMoviesByLanguage(@Query("with_original_language") language: String): MovieDtoResponse
}




























































