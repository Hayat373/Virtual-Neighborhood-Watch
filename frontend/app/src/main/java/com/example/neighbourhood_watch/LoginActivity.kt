package com.example.neighbourhood_watch

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.neighbourhood_watch.AppNavHost
import com.example.neighbourhood_watch.ui.theme.NEIGHBOURHOOD_WATCHTheme
import com.example.neighbourhood_watch.viewmodel.AuthViewModel

class LoginActivity : ComponentActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)

        // Set the Compose UI content
        setContent {
            // Wrap your UI in a Theme
            NEIGHBOURHOOD_WATCHTheme  {

                // Initialize navigation controller for navigation
                val navController = rememberNavController()

                // Initialize the ViewModel for authentication
                val authViewModel: AuthViewModel = viewModel()

                // Pass the navController and the loginState (role) from ViewModel to AppNavHost
                AppNavHost(navController = navController, role = authViewModel.loginState)
            }
        }
    }
}
