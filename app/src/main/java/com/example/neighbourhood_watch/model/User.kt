package com.example.neighbourhood_watch.model

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val password: String,
    val placeOfResidence: ResidencePlace,
    val role: UserRole,
    val incidents: List<Incident>,
    val tips: List<Tip>
)

enum class ResidencePlace {
    K6, K5, K4, SEFERESSELAM, LDETA, COMMERCE
}

enum class UserRole {
    user, admin
}