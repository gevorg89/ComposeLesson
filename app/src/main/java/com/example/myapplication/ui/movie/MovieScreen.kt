package com.example.myapplication.ui.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.timesheet.utils.DEFAULT_RECIPE_IMAGE
import com.example.timesheet.utils.loadPicture
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Preview
@Composable
fun MovieScreen(movieViewModel: MovieViewModel = viewModel(), movieId: Long = 0) {
    movieViewModel.getMovie(movieId)
    val movieState by movieViewModel.movie.observeAsState()
    movieState?.let { movie ->
        Column {
            Text(text = movie.title)
            Text(text = movie.release_date)
            val image = loadPicture(
                url = "https://image.tmdb.org/t/p/original" + movie.poster_path,
                defaultImage = DEFAULT_RECIPE_IMAGE
            ).value
            image?.let { img ->
                Image(
                    contentDescription = null,
                    bitmap = img.asImageBitmap(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = movie.revenue.toEngineeringString())
        }
    }
}