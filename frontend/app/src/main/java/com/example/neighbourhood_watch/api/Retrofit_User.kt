package com.example.neighbourhood_watch.api





import com.example.neighbourhood_watch.model.Incident
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import kotlin.jvm.java

object RetrofitClientUser {
    private const val BASE_URL = "http://10.0.2.2:3000/" // Your API base URL

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Create the API service
    val instance: IncidentApiService = retrofit.create(IncidentApiService::class.java)
    val authApi: AuthApi = retrofit.create(AuthApi::class.java)

}