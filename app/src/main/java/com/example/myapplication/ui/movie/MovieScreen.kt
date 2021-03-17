package com.example.myapplication.ui.movie

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview
@Composable
fun MovieScreen(movieViewModel: MovieViewModel = viewModel()) {
    Text(text = "Movie")
}