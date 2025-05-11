package com.example.neighbourhood_watch.repository
// Import your LoginRequest data class
import com.example.neighbourhood_watch.api.RetrofitInstance
import com.example.neighbourhood_watch.model.LoginRequest
import com.example.neighbourhood_watch.model.LoginResponse


class AuthRepository {
    suspend fun login(email: String, password: String): LoginResponse? {
        println("🚀 Sending login request for: $email")
        return try {
            val response = RetrofitInstance.api.login(LoginRequest(email, password))
            println("✅ Response code: ${response.code()}")
            println("✅ Response body: ${response.body()}")

            if (response.isSuccessful) {
                response.body()
            } else {
                println("❌ Login failed: ${response.errorBody()?.string()}")
                null
            }
        } catch (e: Exception) {
            println("🔥 Exception during login: ${e.message}")
            null
        }
    }
}