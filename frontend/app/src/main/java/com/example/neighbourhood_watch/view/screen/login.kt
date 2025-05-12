package com.example.neighbourhood_watch.view.screen


import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import model.LoginRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.neighbourhood_watch.AdminActivity
import com.example.neighbourhood_watch.R
import com.example.neighbourhood_watch.UserActivity
import com.example.neighbourhood_watch.viewmodel.AuthViewModel


@Composable
fun login(navController: NavHostController, viewModel: AuthViewModel = viewModel()) {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("Option 1", "Option 2", "Option 3")
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    val context = LocalContext.current
    val role = viewModel.loginState

    LaunchedEffect(viewModel.loginState, viewModel.errorMessage) {
        if (viewModel.loginState != null || viewModel.errorMessage != null) {
            var isLoading = false
        }
    }


    LaunchedEffect(role) {
        when (role) {
            "admin" -> {
                val intent = Intent(context, AdminActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                context.startActivity(intent)
            }


        "user" -> {
            val intent = Intent(context, UserActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
            }
            else -> {
                // No navigation
            }
        }
    }






    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFCA7F7F)) // your background color

    ) {


        // Bottom left image
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = null,
            modifier = Modifier
                .size(450.dp)
                .align(Alignment.BottomStart)
                .offset(y = (100).dp)
        )

        // Center logo
        Image(
            painter = painterResource(id = R.drawable.logo), // <-- your logo file
            contentDescription = "Logo",
            modifier = Modifier
                .size(100.dp) // adjust size if needed
                .align(Alignment.Center)
                .offset(y = (-270).dp)
        )
        Text(
            text = "Neighbourhood Watch",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier=Modifier
                .offset(y=(300).dp)
                .offset(x=(100).dp)





        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .width(300.dp)    // Set width
                    .height(60.dp),

            )

            Spacer(modifier = Modifier.height(16.dp))


            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .width(300.dp)    // Set width
                    .height(60.dp)

            )

            Spacer(modifier = Modifier.height(24.dp))





            Button(
                onClick = {

                    Toast.makeText(context, "Logged in Successfully!", Toast.LENGTH_SHORT).show()
                    var isLoading = true

                    viewModel.login(email, password)


                },


                        colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF361919)
                ),


            ) {
                Text(
                    text = "Login",
                    fontSize = 14.sp,
                    color = Color(0xFFFFFFFF) // Text color inside button
                )


            }

        }
    }
}
