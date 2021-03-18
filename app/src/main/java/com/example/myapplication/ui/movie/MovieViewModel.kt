package com.example.myapplication.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.MovieRepository
import com.example.myapplication.data.entities.local.MovieModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repo: MovieRepository) : ViewModel() {
    private val _movie: MutableLiveData<MovieModel> = MutableLiveData()
    val movie = _movie

    fun getMovie(id: Int) {
        //_movie.value = id
        viewModelScope.launch {
            val movieModel = repo.getMovie(id)
            Timber.d(movie.toString())
            _movie.value = movieModel
        }
    }
}