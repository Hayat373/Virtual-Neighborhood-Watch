package com.example.neighbourhood_watch.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neighbourhood_watch.repository.AuthRepository
import kotlinx.coroutines.launch


class AuthViewModel : ViewModel() {
    var loginState by mutableStateOf<String?>(null)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    private val repo = AuthRepository()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val response = repo.login(email, password)
            if (response != null && response.role != null) {
                loginState = response.role // "admin" or "user"
            } else {
                errorMessage = "Login failed: Check credentials or server"
                loginState = null
            }
        }
    }
}

