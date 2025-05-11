// com/example/nw3/NavGraph.kt
package com.example.neighbourhood_watch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.neighbourhood_watch.view.screen.admin_home
import com.example.neighbourhood_watch.view.screen.login
import com.example.neighbourhood_watch.view.screen.user_home

@Composable
fun AppNavHost(navController: NavHostController, role: String?) {
//    NavHost(navController, startDestination = "login") {
//        composable("login") { login(navController) }
//        composable("admin_home") {
//            admin_home(navController = navController)
//
//
//        }
//        composable("user_home") {
//            user_home()
//        }
//    }

    LaunchedEffect(role) {
        when (role) {
            "admin" -> navController.navigate("admin_home") {
                popUpTo("login") { inclusive = true }
            }

            "user" -> navController.navigate("user_home") {
                popUpTo("login") { inclusive = true }
            }
        }
    }
}
