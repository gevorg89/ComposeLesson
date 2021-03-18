package com.example.myapplication.ui.movielist

import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.Actions
import com.example.myapplication.ui.BottomPagerViewModel
import com.example.myapplication.ui.Destinations
import com.example.myapplication.ui.movie.MovieScreen
import com.example.myapplication.ui.movie.MovieViewModel

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
                MovieListItem(onClick = actions.movieItem, movieTopViewModel)
            }
            composable(Destinations.MovieItem) { backStackEntry ->
                val movieViewModel = hiltNavGraphViewModel<MovieViewModel>()
                MovieScreen(movieViewModel)
            }
        }
    }

}

@Composable
fun MovieListItem(onClick: () -> Unit, movieTopViewModel: MovieTopViewModel = viewModel()) {
    movieTopViewModel.getTop(1)
    Button(onClick = onClick) {
        Text(text = "Click Me!!")
    }
}