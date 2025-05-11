package com.example.neighbourhood_watch.api

import com.example.neighbourhood_watch.model.LoginRequest
import com.example.neighbourhood_watch.model.LoginResponse
import com.example.neighbourhood_watch.model.RegisterRequest
import com.example.neighbourhood_watch.model.RegisterResponse

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthApi {
    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

    @POST("/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>



    @DELETE("users/{id}")
    suspend fun deleteUser(@Path("id") userId: String): Response<Unit>
}

