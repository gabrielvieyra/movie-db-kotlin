package com.example.movie_db_kotlin.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie_db_kotlin.core.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MovieRepository
): ViewModel() {
    var state by mutableStateOf(HomeState())
        private set

    init {
        getUpcomingMovies()
    }

    private fun getUpcomingMovies() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            val movies = repository.getUpcomingMovies()
            state = state.copy(
                upcoming = movies,
                isLoading = true
            )
        }
    }
}

































