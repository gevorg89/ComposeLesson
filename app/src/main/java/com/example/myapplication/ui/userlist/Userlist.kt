package com.example.myapplication.ui.userlist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay


@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun UsersScreen(userViewModel: UserViewModel = viewModel()) {
    val users by userViewModel.users.observeAsState()
    users?.let { UserList(users = it) }
    val search by userViewModel.search.observeAsState("")
    UserSearch(value = search, onValueChange = {
        userViewModel.searchUser(it)
    }
    )
}

@Composable
fun UserSearch(value: String, onValueChange: (String) -> Unit) {
    val searchState = remember { mutableStateOf(value) }
    val scope = rememberCoroutineScope()
    var currentJob by remember { mutableStateOf<Job?>(null) }
    OutlinedTextField(value = searchState.value, onValueChange = {
        currentJob?.cancel()
        currentJob = scope.async {
            delay(250)
            onValueChange(it)
        }
        searchState.value = it
    })
}

@ExperimentalFoundationApi
@Composable
fun UserList(users: MutableList<Pair<Char, MutableList<User>>>) {
    LazyColumn {
        users.forEach { (section, usersHeader) ->
            stickyHeader {
                Text(
                    "Section $section",
                    Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(8.dp)
                )
            }
            items(usersHeader) { user ->
                UserItem(user = user)
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp)
                )
            }
        }
    }

}

@Composable
fun UserItem(user: User) {
    val checkedState = remember { mutableStateOf(user.checked) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)

            .clickable {
                checkedState.value = !checkedState.value
            }, shape = RoundedCornerShape(16.dp)
    ) {
        Column(Modifier.background(color = Color(0xFF0EE055))) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = com.example.myapplication.R.drawable.ic_baseline_directions_transit_24),
                    contentDescription = "",
                    modifier = Modifier.size(250.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = user.name, color = Color.White)
                Checkbox(checked = checkedState.value, onCheckedChange = {
                    user.checked = it
                    checkedState.value = it
                }
                )
            }
        }

    }
}