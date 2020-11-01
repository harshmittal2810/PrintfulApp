package com.harsh.printfulapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harsh.printfulapp.ui.repo.TcpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel @ViewModelInject constructor(private val tcpClient: TcpClient) : ViewModel() {

    @ExperimentalCoroutinesApi
    private var users = MutableStateFlow("")

    fun fetchUsers() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                tcpClient.run(users)
            }
        }
    }

    @ExperimentalCoroutinesApi
    fun getUsers(): StateFlow<String> {
        return users
    }
}