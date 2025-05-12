package com.example.neighbourhood_watch.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neighbourhood_watch.api.AuthApi
import com.example.neighbourhood_watch.api.RetrofitClientUser
import com.example.neighbourhood_watch.model.User
import kotlinx.coroutines.launch

class UserModel : ViewModel() {

    // Mock function to represent a user database or repository
    private val userDatabase = mutableListOf<User>()

    // Function to delete a user by ID
    fun deleteUser(
        userId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            Log.d("UserModel", "deleteUser called with ID: $userId")

            try {
                val response = RetrofitClientUser.authApi.deleteUser(userId.toString())
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    onError("Failed with code: ${response.code()}")
                }
            } catch (e: Exception) {
                onError(e.localizedMessage ?: "Unknown error")
            }
        }
    }



}