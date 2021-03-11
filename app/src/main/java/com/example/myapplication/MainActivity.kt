package com.example.myapplication

import android.os.Bundle
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
import com.example.myapplication.ui.theme.AppTheme
import com.example.myapplication.ui.theme.MaterialColors
import com.example.myapplication.ui.userlist.UsersScreen

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                val selectedState = remember { mutableStateOf(0) }
                Surface(color = MaterialTheme.colors.background) {
                    //Greeting("Android")
                    //UsersScreen()
                    Scaffold(
                        content = {
                            if (selectedState.value == 0) {
                                UsersScreen()
                            } else Text(text = "Content")

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
                                                selectedState.value = 0
                                            })
                                        BuildBottomMenuItem(
                                            iconAsset = Icons.Filled.Create,
                                            text = "Item 2",
                                            click = {
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