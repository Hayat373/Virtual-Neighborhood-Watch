package com.example.neighbourhood_watch.view.screen

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.navigation.NavController

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.sp

import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.rememberNavController
import com.example.neighbourhood_watch.R
import com.example.neighbourhood_watch.api.RetrofitInstance
import com.example.neighbourhood_watch.model.RegisterRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext








@Preview(showBackground = true)
@Composable
fun register(navController: NavController? = null) {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("Choose your location") }
    val options = listOf("6 Kilo", "5 Kilo", "4 Kilo", "Sefere Selam", "Lideta")
    val context = LocalContext.current





    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFCA7F7F)) // your background color
    ) {


        // Bottom left image
        Image(
            painter = painterResource(id = R.drawable.register),
            contentDescription = null,
            modifier = Modifier
                .size(450.dp)
                .align(Alignment.BottomCenter)
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

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
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
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier
                    .width(300.dp)    // Set width
                    .height(60.dp)
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



            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .wrapContentSize(Alignment.TopStart)

            ) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    shadowElevation = 4.dp,
                    color = Color.White,
                    modifier = Modifier
                        .clickable { expanded = true }
                        .border(1.dp, Color.Gray, RoundedCornerShape(10.dp))
                ){
                // This is the "Button"
                Row(
                    modifier = Modifier
                        .background(Color.White)
                        .clickable { expanded = true }
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = selectedOptionText,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF361919),
                        modifier = Modifier.weight(1f) // push the text to the start
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.down_menu), // use your own icon
                        contentDescription = null,
                        tint = Color(0xFF361919),
                        modifier = Modifier
                            .size(15.dp)
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },

                    modifier = Modifier
                        .background(Color.White)
                        .width(300.dp)    // Set width
                        .height(250.dp)

                ) {
                    options.forEach { label ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = label,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Black
                                )
                            },

                            onClick = {
                                selectedOptionText = label
                                expanded = false
                            }
                        )
                    }
                }
            }}

            Spacer(modifier = Modifier.height(24.dp))
            Button(

                onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            val response = RetrofitInstance.api.register(
                                RegisterRequest(email, username, password, selectedOptionText)
                            )
                            withContext(Dispatchers.Main) {
                                if (response.isSuccessful && response.body()?.success == true) {
                                    Toast.makeText(context, "Registered successfully!", Toast.LENGTH_LONG).show()
                                    // navController?.navigate("login")
                                } else {
                                    Toast.makeText(context, "Registered successfully!: ${response.body()?.message}", Toast.LENGTH_LONG).show()
                                }
                            }
                        } catch (e: Exception) {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(context, "Network error: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                },
                // Existing button properties...

            colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF361919) // Green background, you can change it
                ),
                shape = RoundedCornerShape(8.dp),

                modifier = Modifier
                    .width(102.dp) // Set width to 32dp
                    .padding(bottom = 16.dp),

                ) {
                Text(
                    text = "Register",
                    fontSize = 14.sp,
                    color = Color(0xFFFFFFFF) // Text color inside button
                )
            }

        }

    }
}