package com.example.neighbourhood_watch

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size

import androidx.compose.ui.Alignment


import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background // <--- for .background()

import androidx.compose.ui.graphics.Color // <--- for Color.White or custom colors
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.neighbourhood_watch.ui.theme.NEIGHBOURHOOD_WATCHTheme
import com.example.neighbourhood_watch.R
import com.example.neighbourhood_watch.view.screen.admin_home
import com.example.neighbourhood_watch.view.screen.login
import com.example.neighbourhood_watch.view.screen.register
import com.example.neighbourhood_watch.view.screen.user_home
import com.example.neighbourhood_watch.viewmodel.AuthViewModel



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()


            NavHost(navController = navController, startDestination = "NEIGHBOURHOOD_WATCH") {
                composable("NEIGHBOURHOOD_WATCH") { NEIGHBOURHOOD_WATCHScreen(navController) }
                composable("login") { login(navController) }
                composable("register") { register(navController) }
                composable("user_home") {
                    user_home(
                    username= "",
                    onTipUserClick ={ },
                    onReportUserClick={},
                    onpriviousUserClick= { },
                    onSettingsUserClick={},
                    onEmergencyClick ={ }

                ) }
                composable("admin_home") {
                    admin_home(

                        onTipClick = {  },
                        onIncidentsClick = { },
                        onSettingsClick = { }
                    )}
            }
        }
    }


    @Composable
    fun NEIGHBOURHOOD_WATCHScreen(navController: NavController) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCA7F7F)) // your background color
        ) {
            // Top right image
            Image(
                painter = painterResource(id = R.drawable.topright),
                contentDescription = null,
                modifier = Modifier
                    .size(450.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = (-90).dp)
            )

            // Bottom left image
            Image(
                painter = painterResource(id = R.drawable.bottomleft),
                contentDescription = null,
                modifier = Modifier
                    .size(450.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = (105).dp)
            )

            // Center logo
            Image(
                painter = painterResource(id = R.drawable.logo), // <-- your logo file
                contentDescription = "Logo",
                modifier = Modifier
                    .size(100.dp) // adjust size if needed
                    .align(Alignment.Center)
                    .offset(y = (-220).dp)
            )



            Column(

                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = (-50).dp)
                    .width(250.dp)

            ) {
                Text(
                    text = "Neighbourhood Watch",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White


                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Neighbourhood watch is a simple app where people can report and share local incidents in real time. Users can post updates with photos and locations, stay informed, and get helpful safety tips from the community.",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,


                )
            }

            Spacer(modifier = Modifier.height(132.dp))

            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 200.dp)
                    .offset(y = (60).dp),

                horizontalAlignment = Alignment.CenterHorizontally // to center buttons horizontally
            ) {


                Button(
                    onClick = {
                        navController.navigate("login")
                    },


                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFFFFF) // Green background, you can change it
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .width(102.dp) // Set width to 32dp
                        .padding(bottom = 16.dp)
                ) {
                    Text(
                        text = "Login",
                        fontSize = 14.sp,
                        color = Color(0xFF361919) // Text color inside button
                    )
                }

                Spacer(modifier = Modifier.height(16.dp)) // Space between button and "OR"

                Text(
                    text = "OR",
                    color = Color.White,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(16.dp)) // Space between "

                Button(
                    onClick = {
                        navController.navigate("register")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF361919) // Blue background, you can change it
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .width(102.dp) // Set width to 32dp
                ) {
                    Text(
                        text = "Register",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }

            }
        }

    }


    }


