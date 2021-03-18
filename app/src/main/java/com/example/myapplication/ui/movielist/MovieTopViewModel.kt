package com.example.myapplication.ui.movielist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.myapplication.MovieRepository
import com.example.myapplication.data.entities.local.MovieModel
import com.example.myapplication.data.entities.local.ResultModel
import com.example.myapplication.data.remote.MoviePagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieTopViewModel @Inject constructor(private val repo: MovieRepository) : ViewModel() {

    val movies: Flow<PagingData<ResultModel>> = Pager(PagingConfig(pageSize = 20)) {
        MoviePagingSource(repo)
    }.flow

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