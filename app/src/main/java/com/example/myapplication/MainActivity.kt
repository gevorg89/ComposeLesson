package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.BottomPagerViewModel
import com.example.myapplication.ui.ContentScreen
import com.example.myapplication.ui.movie.MovieScreen
import com.example.myapplication.ui.theme.AppTheme
import com.example.myapplication.ui.theme.MaterialColors
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random
//389ab18e8c7ba5c6ac629e72f354954c
//eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzODlhYjE4ZThjN2JhNWM2YWM2MjllNzJmMzU0OTU0YyIsInN1YiI6IjYwNTI2MWRiOTc2YTIzMDA1MzMxMzk1MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gWeJN3EGHn0cYE28Enwxq9pfwAiSCg-oeFYOMjawhrc
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                //MovieScreen(taskId = backStackEntry.arguments?.getInt(TaskId) ?: 0)
                // A surface container using the 'background' color from the theme
                val selectedState = remember { mutableStateOf(0) }
                val secondScreen: ComposableFun = {
                    Text(text = "Content " + Random.nextInt(0, 10))
                }
                val pagerViewModel = BottomPagerViewModel()
                Surface(color = MaterialTheme.colors.background) {
                    //Greeting("Android")
                    //UsersScreen()
                    Scaffold(
                        content = {

                            ContentScreen(pagerViewModel)
                            /*Log.d("asdasda", "true")
                            if (selectedState.value == 0) {
                                UsersScreen()
                            } else secondScreen()*/

                        },
                        bottomBar = {
                            BottomAppBar(
                                backgroundColor = MaterialColors.surface,
                                contentColor = contentColorFor(MaterialColors.surface),
                                cutoutShape = CircleShape
                            ) {
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Row(modifier = Modifier.weight(1f)) {
                                        Box(modifier = Modifier.width(8.dp))
                                        BuildBottomMenuItem(
                                            iconAsset = Icons.Filled.Favorite,
                                            text = "Item 1",
                                            click = {
                                                pagerViewModel.firstTab.value = true
                                                selectedState.value = 0
                                            })
                                        BuildBottomMenuItem(
                                            iconAsset = Icons.Filled.Create,
                                            text = "Item 2",
                                            click = {
                                                pagerViewModel.secondTab.value = true
                                                selectedState.value = 1
                                            })
                                    }
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

typealias ComposableFun = @Composable () -> Unit

@Composable
fun BuildBottomMenuItem(iconAsset: ImageVector, text: String, click: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.absolutePadding(left = 8.dp, right = 8.dp)
    ) {
        IconButton(click, modifier = Modifier.size(24.dp)) {
            Icon(iconAsset, "")
        }
        Text(text = text)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        Greeting("Android")
    }
}