package com.example.neighbourhood_watch.api


import com.example.neighbourhood_watch.model.Incident
import com.example.neighbourhood_watch.model.Tip
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.Path
import retrofit2.http.PUT
import retrofit2.http.DELETE

interface TipApiService {
    @GET("tips") // Replace with the correct path
    suspend fun getTips(): List<Tip> // Adjust the return type based on your API
}

interface IncidentApiService {
    @GET("incidents") // Replace with your actual endpoint
    suspend fun getIncidents(): List<Incident>

    @POST("incidents") // Replace with your actual endpoint for creating incidents
    suspend fun createIncident(@Body incident: Incident): Incident

    @PUT("incidents/{id}") // Replace with your actual endpoint for updating incidents
    suspend fun updateIncident(@Path("id") id: Int, @Body incident: Incident): Incident

    @DELETE("incidents/{id}") // Endpoint for deleting incidents
    suspend fun deleteIncident(@Path("id") id: Int)
}