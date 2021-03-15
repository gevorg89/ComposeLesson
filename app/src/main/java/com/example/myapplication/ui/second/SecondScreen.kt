package com.example.myapplication.ui.second

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.BottomPagerViewModel
import kotlin.random.Random

@Composable
fun SecondScreen(pagerViewModel: BottomPagerViewModel = viewModel()) {
    val state by pagerViewModel.secondTab.observeAsState(false)
    val alpha = if (state) 1f else 0f
    Surface(Modifier.alpha(alpha)) {
        //val t = state
        Text(text = "Content " + Random.nextInt(0, 10))
    }

}