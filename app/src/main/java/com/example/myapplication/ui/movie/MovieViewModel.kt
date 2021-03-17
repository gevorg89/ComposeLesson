package com.example.myapplication.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(repo: MovieRepository) : ViewModel() {
    private val _movie = MutableLiveData(0L)
    val movie = _movie

    init {
        viewModelScope.launch {
            val movie = repo.getMovie(76341)
            println()
        }
    }

    fun getMovie(id: Long) {
        _movie.value = id
    }
}