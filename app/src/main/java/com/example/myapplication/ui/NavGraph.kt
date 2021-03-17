package com.example.myapplication.ui

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.myapplication.ui.Destinations.SecondScreenInner
import com.example.myapplication.ui.Destinations.UserDetail

object Destinations {
    const val UserList = "userList"
    const val SecondScreen = "secondScreen"
    const val SecondScreenInner = "secondScreenInner"
    const val UserDetail = "userDetail"

    object TaskDetailArgs {
        const val TaskId = "taskId"
    }
}

class Actions(navController: NavHostController) {
    val secondScreenInner: () -> Unit = {
        navController.navigate(SecondScreenInner)
    }
    val userDetail: () -> Unit = {
        navController.navigate(UserDetail)
    }
    /*val openTask: (Int) -> Unit = { taskId ->
        navController.navigate("$TaskDetail/$taskId")
    }
    val addTask: () -> Unit = {
        navController.navigate(AddTask)
    }
    val editTask: (Int) -> Unit = { taskId ->
        navController.navigate("$EditTask/$taskId")
    }
    val addProject: () -> Unit = {
        navController.navigate(AddProject)
    }
    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }*/
}
