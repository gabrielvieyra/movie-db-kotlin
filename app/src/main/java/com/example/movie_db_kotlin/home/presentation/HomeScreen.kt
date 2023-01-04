package com.example.movie_db_kotlin.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state = viewModel.state

    // En este caso usamos LazyColumn por que la columna tiene que ser scrolleable
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        if (state.upcoming.isNotEmpty()) {
            item {
                Text(text = "Proximos estrenos")
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(state.upcoming) {
                        Text(text = it.title)
                    }
                }
            }
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



















