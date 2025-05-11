package com.example.neighbourhood_watch.viewmodel




import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neighbourhood_watch.api.IncidentApiService
import com.example.neighbourhood_watch.model.Incident

import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java

class PreviousIncidentViewModel : ViewModel() {
    private val _incidents = mutableStateOf<List<Incident>>(emptyList())
    val incidents: State<List<Incident>> get() = _incidents // Expose incidents as State

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:3000/") // Replace with your API endpoint
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(IncidentApiService::class.java)

    fun fetchIncidents() {
        viewModelScope.launch {
            try {
                val response = apiService.getIncidents()
                _incidents.value = response // Update state with fetched incidents
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}