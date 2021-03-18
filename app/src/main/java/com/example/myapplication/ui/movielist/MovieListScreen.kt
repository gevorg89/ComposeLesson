package com.example.myapplication.ui.movielist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.myapplication.data.entities.local.ResultModel
import com.example.myapplication.ui.Actions
import com.example.myapplication.ui.BottomPagerViewModel
import com.example.myapplication.ui.Destinations
import com.example.myapplication.ui.Destinations.MovieDetailArgs.MovieId
import com.example.myapplication.ui.Destinations.MovieItem
import com.example.myapplication.ui.movie.MovieScreen
import com.example.myapplication.ui.movie.MovieViewModel
import com.example.timesheet.utils.DEFAULT_RECIPE_IMAGE
import com.example.timesheet.utils.loadPicture
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun MovieListScreen(
    pagerViewModel: BottomPagerViewModel = viewModel()
) {
    val state by pagerViewModel.firstTab.observeAsState(false)
    val alpha = if (state) 1f else 0f
    Scaffold(Modifier.alpha(alpha)) {
        val navController = rememberNavController()
        val actions = remember(navController) { Actions(navController) }
        NavHost(navController, startDestination = Destinations.MovieList) {
            composable(Destinations.MovieList) { backStackEntry ->
                val movieTopViewModel = hiltNavGraphViewModel<MovieTopViewModel>()
                MovieListContainer(onClick = actions.movieItem, movieTopViewModel)
            }
            composable(
                "$MovieItem/{$MovieId}",
                arguments = listOf(navArgument(MovieId) { type = NavType.IntType })
            ) { backStackEntry ->
                val movieViewModel = hiltNavGraphViewModel<MovieViewModel>()
                MovieScreen(
                    movieViewModel,
                    movieId = backStackEntry.arguments?.getInt(MovieId) ?: 0
                )
            }
        }
    }
}

@ExperimentalCoroutinesApi
@Composable
fun MovieListContainer(onClick: (Int) -> Unit, movieTopViewModel: MovieTopViewModel = viewModel()) {
    val lazyMovieItems: LazyPagingItems<ResultModel> =
        movieTopViewModel.movies.collectAsLazyPagingItems()
    LazyColumn(
        contentPadding = PaddingValues(16.dp, 16.dp, 16.dp)
    ) {
        items(lazyMovieItems) { movie ->
            MovieListItem(onClick = onClick, movie = movie!!)
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(16.dp))
        }
    }

}

@ExperimentalCoroutinesApi
@Composable
fun MovieListItem(onClick: (Int) -> Unit, movie: ResultModel) {
    Card(
        Modifier
            .height(100.dp)
            .clickable { onClick(movie.id) }) {
        Row() {
            val image = loadPicture(
                url = "https://image.tmdb.org/t/p/w500" + movie.posterPath,
                defaultImage = DEFAULT_RECIPE_IMAGE
            ).value
            image?.let { img ->
                Image(
                    contentDescription = null,
                    bitmap = img.asImageBitmap(),
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column() {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp),
                    text = movie.title
                )
                /*Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp),
                    text = movie.overview
                )*/
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp),
                    text = movie.releaseDate
                )
            }

        }
    }
}