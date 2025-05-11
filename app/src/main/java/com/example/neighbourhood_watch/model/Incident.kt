package com.example.neighbourhood_watch.model

data class Incident(
    val id: Int, // Use the correct type based on your API response
    val description: String,
    val location: String,
    val title: String

) {
}