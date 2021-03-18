package com.example.myapplication.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.movielist.MovieListScreen
import com.example.myapplication.ui.second.SecondScreen
import com.example.myapplication.ui.userlist.UsersScreen

@Preview
@ExperimentalFoundationApi
@Composable
fun ContentScreen(pagerViewModel: BottomPagerViewModel = viewModel()) {
    MovieListScreen(pagerViewModel)
    SecondScreen(pagerViewModel)
}


class BottomPagerViewModel : ViewModel() {
    private val _firstTab: MutableLiveData<Boolean> = MutableLiveData(true)
    val firstTab = _firstTab

    private val _secondTab: MutableLiveData<Boolean> = MutableLiveData(false)
    val secondTab = _secondTab

    init {
        firstTab.observeForever {
            if (it){
                secondTab.value = false
            }
        }

        secondTab.observeForever {
            if (it){
                firstTab.value = false
            }
        }
    }
}