package com.example.neighbourhood_watch.model



data class RegisterRequest(
    val email: String,
    val username: String,
    val password: String,
    val location: String
)
