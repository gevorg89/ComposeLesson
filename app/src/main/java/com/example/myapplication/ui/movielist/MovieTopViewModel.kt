package com.example.myapplication.ui.movielist

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
class MovieTopViewModel @Inject constructor(private val repo: MovieRepository) : ViewModel() {
    private val _movie: MutableLiveData<MovieModel> = MutableLiveData()
    val movie = _movie

    fun getTop(page: Int) {
        //_movie.value = id
        viewModelScope.launch {
            val movieModel = repo.getTop(page)
            Timber.d(movie.toString())
        }
    }
}