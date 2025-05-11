package com.example.neighbourhood_watch.viewmodel



import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neighbourhood_watch.api.RetrofitClientAdmin
import com.example.neighbourhood_watch.model.Incident


import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IncidentViewModel : ViewModel() {
    private val _incidents = mutableStateOf<List<Incident>>(emptyList())
    val incidents: State<List<Incident>> = _incidents

    init {
        fetchIncidents()
    }

    fun fetchIncidents() {
        viewModelScope.launch {
            RetrofitClientAdmin.apiService.getIncidents().enqueue(object : Callback<List<Incident>> {
                override fun onResponse(call: Call<List<Incident>>, response: Response<List<Incident>>) {
                    if (response.isSuccessful) {
                        _incidents.value = response.body() ?: emptyList()
                    } else {
                        Log.e("IncidentViewModel", "Error fetching incidents: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<List<Incident>>, t: Throwable) {
                    Log.e("IncidentViewModel", "Failed to fetch incidents: ${t.message}")
                }
            })
        }
    }
}