package com.example.neighbourhood_watch.utils

import android.util.Base64
import org.json.JSONObject

fun decodeJwtRole(token: String): String? {
    val parts = token.split(".")
    if (parts.size != 3) return null
    val payload = String(Base64.decode(parts[1], Base64.DEFAULT))
    val json = JSONObject(payload)
    return json.optString("role")
}