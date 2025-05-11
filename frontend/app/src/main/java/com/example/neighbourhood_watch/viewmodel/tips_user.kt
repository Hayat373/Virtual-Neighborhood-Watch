package com.example.neighbourhood_watch.viewmodel




import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neighbourhood_watch.api.TipApiService
import com.example.neighbourhood_watch.model.Tip

import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TipsViewModel : ViewModel() {
    private val _tips = mutableStateOf<List<Tip>>(emptyList())
    val tips: State<List<Tip>> get() = _tips // Expose tips as State

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:3000/") // Replace with your API endpoint
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(TipApiService::class.java)

    fun fetchTips() {
        viewModelScope.launch {
            try {
                val response = apiService.getTips()
                _tips.value = response // Update state with fetched tips
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}