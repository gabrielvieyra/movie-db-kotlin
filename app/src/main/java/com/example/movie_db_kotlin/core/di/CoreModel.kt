package com.example.movie_db_kotlin.core.di

import com.example.movie_db_kotlin.core.data.MovieRepositoryImp
import com.example.movie_db_kotlin.core.data.remote.MovieApi
import com.example.movie_db_kotlin.core.data.remote.interceptor.ApiKeyInterceptor
import com.example.movie_db_kotlin.core.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {
    // Proveemos la api
    @Provides
    @Singleton
    // Se le suele llamar provide por que lo que vamos a hacer es proveer una dependencia
    fun provideApi(): MovieApi {
        val client = OkHttpClient.Builder().addInterceptor(ApiKeyInterceptor()).build()
        return Retrofit.Builder().baseUrl(MovieApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create()).client(client).build().create()
    }

    // Proveemos el repository
    @Singleton
    @Provides
    fun provideRepository(
        api: MovieApi
    ): MovieRepository {
        return MovieRepositoryImp(api)
    }
}



























