package com.example.myapplication.ui.second

import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.Actions
import com.example.myapplication.ui.BottomPagerViewModel
import com.example.myapplication.ui.Destinations.SecondScreen
import com.example.myapplication.ui.Destinations.SecondScreenInner
import kotlin.random.Random

@Composable
fun SecondScreen(pagerViewModel: BottomPagerViewModel = viewModel()) {
    val state by pagerViewModel.secondTab.observeAsState(false)
    val alpha = if (state) 1f else 0f
    Scaffold(Modifier.alpha(alpha)) {
        val navController = rememberNavController()
        val actions = remember(navController) { Actions(navController) }
        NavHost(navController, startDestination = SecondScreen) {
            composable(SecondScreen) { backStackEntry ->
                SecondScreenData(actions.secondScreenInner)
            }
            composable(SecondScreenInner) { backStackEntry ->
                SecondInnerScreen()
            }
        }
    }
}

@Composable
fun SecondScreenData(secondScreenInner: () -> Unit) {
    Scaffold(
        content = {
            Button(onClick = secondScreenInner) {
                Text(text = "Content " + Random.nextInt(0, 10))
            }
        }
    )
}