package com.example.neighbourhood_watch.viewmodel

import com.example.neighbourhood_watch.model.Incident


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neighbourhood_watch.api.IncidentApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserReportViewModel : ViewModel() {
    private val _incidents = mutableStateOf<List<Incident>>(emptyList())
    val incidents: State<List<com.example.neighbourhood_watch.model.Incident>> get() = _incidents

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
                // Handle error (e.g., log the error)
                Log.e("UserReportViewModel", "Error fetching incidents", e)
            }
        }
    }

    // Function to create a new incident
    fun createIncident(incident: Incident) {
        viewModelScope.launch {
            try {
                val newIncident = apiService.createIncident(incident)
                // Update the incidents list with the new incident
                _incidents.value = _incidents.value + newIncident
            } catch (e: Exception) {
                Log.e("UserReportViewModel", "Error creating incident", e)
            }
        }
    }

    // Function to update an existing incident
    fun updateIncident(id: Int, updatedIncident: Incident) {
        viewModelScope.launch {
            try {
                val result = apiService.updateIncident(id, updatedIncident)
                // Update the incidents list with the edited incident
                _incidents.value = _incidents.value.map {
                    if (it.id == id) result else it
                }
            } catch (e: Exception) {
                Log.e("UserReportViewModel", "Error updating incident", e)
            }
        }
    }

    // Function to delete an incident
    fun deleteIncident(id: Int) {
        viewModelScope.launch {
            try {
                apiService.deleteIncident(id) // Call the API to delete the incident
                // Update the incidents list by removing the deleted incident
                _incidents.value = _incidents.value.filter { it.id != id }
            } catch (e: Exception) {
                Log.e("UserReportViewModel", "Error deleting incident", e)
            }
        }
    }
}