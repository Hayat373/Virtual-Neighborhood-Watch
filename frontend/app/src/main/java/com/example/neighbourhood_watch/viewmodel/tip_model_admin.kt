package com.example.neighbourhood_watch.viewmodel


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neighbourhood_watch.api.RetrofitClientAdmin
import com.example.neighbourhood_watch.model.EditTipDto
import com.example.neighbourhood_watch.model.Tip

import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TipViewModel : ViewModel() {
    private val _tips = mutableStateOf<List<Tip>>(emptyList())
    val tips: State<List<Tip>> = _tips

    init {
        fetchTips()
    }

    fun fetchTips() {
        viewModelScope.launch {
            try {
                val response = RetrofitClientAdmin.apiService.getTips()
                response.enqueue(object : Callback<List<Tip>> {
                    override fun onResponse(call: Call<List<Tip>>, response: Response<List<Tip>>) {
                        if (response.isSuccessful) {
                            _tips.value = response.body() ?: emptyList()
                        } else {
                            Log.e("TipViewModel", "Error fetching tips: ${response.code()}")
                        }
                    }

                    override fun onFailure(call: Call<List<Tip>>, t: Throwable) {
                        Log.e("TipViewModel", "Failed to fetch tips: ${t.message}")
                    }
                })
            } catch (e: Exception) {
                Log.e("TipViewModel", "Failed to fetch tips: ${e.message}")
            }
        }
    }

    fun editTip(id: Int, editTipDto: EditTipDto) {
        viewModelScope.launch {
            RetrofitClientAdmin.apiService.editTip(id, editTipDto).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        Log.d("TipViewModel", "Tip edited successfully")
                        fetchTips() // Refresh the list
                    } else {
                        Log.e("TipViewModel", "Error editing tip: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.e("TipViewModel", "Error editing tip: ${t.localizedMessage}")
                }
            })
        }
    }

    fun deleteTip(id: Int) {
        viewModelScope.launch {
            RetrofitClientAdmin.apiService.deleteTip(id).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        Log.d("TipViewModel", "Tip deleted successfully")
                        fetchTips() // Refresh the list
                    } else {
                        Log.e("TipViewModel", "Error deleting tip: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.e("TipViewModel", "Error deleting tip: ${t.localizedMessage}")
                }
            })
        }
    }
}