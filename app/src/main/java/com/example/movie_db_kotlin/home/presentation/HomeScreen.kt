package com.example.movie_db_kotlin.home.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movie_db_kotlin.home.presentation.components.*

const val COLUMNS_IN_GRID = 2
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state = viewModel.state

    // En este caso usamos LazyColumn por que la columna tiene que ser scrolleable
    /*LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(start = 25.dp)) {
        item { Spacer(modifier = Modifier.height(24.dp))}
        if (state.upcomingMovies.isNotEmpty()) {
            item {
                HomeMovieList(title = "Proximos Estrenos", posters = state.upcomingMovies.map { it.image })
            }
        }
        item { Spacer(modifier = Modifier.height(24.dp))}
        if (state.popularMovies.isNotEmpty()) {
            item {
                HomeMovieList(title = "Tendencia", posters = state.popularMovies.map { it.image })
            }
        }
        item { Spacer(modifier = Modifier.height(24.dp))}
        item {
            HomeRecommended(selectedFilter = state.selectedFilter, onFilterClick = {
                viewModel.onEvent(HomeEvent.ChangeFilter(it))
            }, movieList = state.filteredMovies) {
            }
        }
    }*/
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().padding(start = 25.dp, end = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { Spacer(modifier = Modifier.height(24.dp))}
        if (state.upcomingMovies.isNotEmpty()) {
            item(span = {
             GridItemSpan(COLUMNS_IN_GRID)
            }) {
                HomeMovieList(title = "Proximos Estrenos", posters = state.upcomingMovies.map { it.image })
            }
        }

        if (state.popularMovies.isNotEmpty()) {
            item(span = {
                GridItemSpan(COLUMNS_IN_GRID)
            }) {
                HomeMovieList(title = "Tendencia", posters = state.popularMovies.map { it.image })
            }
        }

        if (state.filteredMovies.isNotEmpty()) {
            item(span = {
                GridItemSpan(COLUMNS_IN_GRID)
            }) {
                HomeRecommended(selectedFilter = state.selectedFilter, onFilterClick = {
                    viewModel.onEvent(HomeEvent.ChangeFilter(it))
                })
            }
        }

        items(state.filteredMovies) {
            HomeMoviePoster(it.image, MoviePosterSize.BIG)
        }
    }
    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

/*@Preview(showSystemUi = true)
@Composable
fun Preview() {
    HomeScreen()
}*/



















