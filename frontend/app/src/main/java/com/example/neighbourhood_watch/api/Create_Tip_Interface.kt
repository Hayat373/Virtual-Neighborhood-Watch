package com.example.neighbourhood_watch.api





import com.example.neighbourhood_watch.model.CreateTipDto
import com.example.neighbourhood_watch.model.Incident
import com.example.neighbourhood_watch.model.Tip

import com.example.neighbourhood_watch.model.EditTipDto

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.Path


interface CreateTipInterface {
    @POST("tips") // Adjust the endpoint as needed
    fun createTip(@Body createTipDto: CreateTipDto): Call<Void>
}

interface ApiService {
    @GET("tips")
    fun getTips(): Call<List<Tip>> // Return type should be Call<List<Tip>>

    @GET("incidents")
    fun getIncidents(): Call<List<Incident>>


    @PUT("tips/{id}") // Adjust the endpoint as needed
    fun editTip(@Path("id") id: Int, @Body editTipDto: EditTipDto): Call<Void>

    @DELETE("tips/{id}") // Adjust the endpoint as needed
    fun deleteTip(@Path("id") id: Int): Call<Void>

    @DELETE("users/{id}")
    suspend fun deleteUser(@Path("id") userId: Int)
}