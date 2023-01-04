package com.example.movie_db_kotlin.core.data.remote

import com.example.movie_db_kotlin.core.data.remote.dto.MovieDtoResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// Para hacer una pegada a la api tenemos que crear una instancia de retrofit
// Nos creamos una interfaz, usamos interfaz ya que retrofit usa interfaces
interface MovieApi {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    // Al poner suspend adelante de un metodo estamos diciendo que este codigo tiene que correr si o si en corrutinas
    // Los metodos de corrutinas generalmente se van a llamar dentro de un ViewModel

    // Le avisamos a retrofit que esto es una pegada get y le pasamos el endpoint
    @GET("movie/upcoming")
    // Este metodo va a retornar un listado de peliculas que se van a estrenar proximamente
    suspend fun getUpcomingMovies(): MovieDtoResponse
    // Para llamar a MovieApi usamos repository que es algo que recomienda google
}




























































