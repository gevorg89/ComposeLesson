package com.example.myapplication.ui.userlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val _loadedUsers = MutableLiveData<MutableList<Pair<Char, MutableList<User>>>>()
    private val _users = MutableLiveData<MutableList<Pair<Char, MutableList<User>>>>()
    val users = _users

    private val _search = MutableLiveData<String>("")
    val search = _search

    init {
        if (_search.value == "") {
            fetchUsers()
        }
    }

    private fun fetchUsers() {
        val data = mutableListOf<Pair<Char, MutableList<User>>>()
        ('A'..'Z').map { groupIndex ->
            data.add(groupIndex to (0..10).map { userIndex ->
                User(name = "User $groupIndex$userIndex")
            }.toMutableList())
        }
        _loadedUsers.value = data
        _users.value = data
    }


    fun searchUser(text: String) {
        _search.value = text
        val t = _loadedUsers.value?.filter {
            it.second.any { user ->
                user.name.toLowerCase().contains(text.toLowerCase())
            }
        }
            ?.toMutableList()
        _users.value = t
    }
}