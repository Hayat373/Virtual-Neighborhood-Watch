package com.example.neighborhood_watch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neighbourhood_watch.model.User
import kotlinx.coroutines.launch

class UserModel : ViewModel() {

    // Mock function to represent a user database or repository
    private val userDatabase = mutableListOf<User>()

    // Function to delete a user by ID
    fun deleteUser(userId: Int, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            val userToDelete = userDatabase.find { it.id == userId }
            if (userToDelete != null) {
                userDatabase.remove(userToDelete)
                onSuccess() // Call the success callback
            } else {
                onError("User not found") // Call the error callback
            }
        }
    }


}