package com.example.movie_db_kotlin.home.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state = viewModel.state
    Text(text =${state})
}

/*@Preview(showSystemUi = true)
@Composable
fun Preview() {
    HomeScreen()
}*/