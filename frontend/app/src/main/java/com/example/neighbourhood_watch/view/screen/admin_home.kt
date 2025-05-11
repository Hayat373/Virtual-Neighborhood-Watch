package com.example.neighbourhood_watch.view.screen



import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.neighbourhood_watch.R



@Composable
fun admin_home(

    onTipClick: () -> Unit,
    onIncidentsClick: () -> Unit,
    onSettingsClick: () -> Unit,
   //navController: NavHostController, username: String = "admin"

) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCA7F7F)) // your background color
                .padding(30.dp)

                .padding(bottom = 250.dp), // Space for the bottom image
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start

        ) {
            Spacer(modifier = Modifier.height(40.dp)) // Adjust width as needed

            // Row for Header Icon and Title
            Row(
                modifier = Modifier
                    .padding(top = 32.dp),
                verticalAlignment = Alignment.CenterVertically // Align items vertically centered
            ) {
                // Header Icon
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.size(77.dp)

                )

                // Title
                Text(
                    text = "Neighbourhood Watch",
                    color = Color.White,
                    fontSize = 20.sp,

                    modifier = Modifier.padding(start = 16.dp),
                    fontWeight = FontWeight.Bold,


                    )
            }

            // Welcome Message
            Text(
                text = "Welcome Back, Admin",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 64.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .align(Alignment.Start)
            ) {
                // Row for Tips Image and Text
                Column(
                    modifier = Modifier
                        .padding(start = 40.dp)

                        .padding(top = 16.dp),

                    ) {
                    // Tips Image
                    Image(
                        painter = painterResource(id = R.drawable.light),
                        contentDescription = null,
                        modifier = Modifier
                            .size(98.dp) // Keeping original size
                            .clickable(onClick = onTipClick)

                    )

                    Spacer(modifier = Modifier.height(7.dp))
                    // Tips Text
                    Text(
                        text = "Tips",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 29.dp) // Space between image and text
                    )
                }

                // Spacer for spacing between the columns
                Spacer(modifier = Modifier.width(25.dp)) // Adjust width as needed

                // Row for Group Image and Previous Incidents Text
                Column(
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    // Group Image
                    Image(
                        painter = painterResource(id = R.drawable.people),
                        contentDescription = null,
                        modifier = Modifier
                            .size(110.dp) // Keeping original size
                            .align(Alignment.End)
                            .clickable(onClick = onIncidentsClick)
                    )

                    Spacer(modifier = Modifier.height(0.dp))

                    // Previous Incidents Text
                    Text(
                        text = "Previous Incidents",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 14.dp)
                            .offset(x = 20.dp)// Space between image and text
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Settings Text
            Column(
                modifier = Modifier
                    .padding(start = 40.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.setting),
                    contentDescription = null,
                    modifier = Modifier
                        .size(110.dp) // Keeping original size

                        .align(Alignment.Start)
                        .clickable(onClick = onSettingsClick)
                )

                Spacer(modifier = Modifier.height(0.dp))

                Text(
                    text = "Settings",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 0.dp , start = 23.dp)

                )
            }
        }
        // Bottom Image
        Image(
            painter = painterResource(id = R.drawable.rectangle),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(250.dp)
                .padding(bottom = 0.dp) // Corrected padding
        )
    }
}

