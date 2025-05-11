package com.example.neighbourhood_watch.view.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neighbourhood_watch.R



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun user_home(
    username: String,
    onTipUserClick: () -> Unit,
    onReportUserClick:() -> Unit,
    onpriviousUserClick: () -> Unit,
    onSettingsUserClick: () -> Unit,
    onEmergencyClick : () -> Unit

) {
    Box(modifier = Modifier.fillMaxSize()
        .height(2000.dp)

    ) {
        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCA7F7F))
                .padding(20.dp)
                .padding(bottom = 230.dp
                ), // Space for the bottom image
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            // Row for Header Icon and Title
            Row(
                modifier = Modifier.padding(top = 40.dp),
                verticalAlignment = Alignment.CenterVertically // Align items vertically centered
            ) {
                // Header Icon
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )

                // Title
                Text(
                    text = "Neighbourhood Watch",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 16.dp) // Add space between icon and title
                )
            }

            // Welcome Message
            Text(
                text = "Welcome Back, User",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 40.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Row(
                modifier = Modifier
                    .padding(top = 30.dp,start = 20.dp)
                    .align(Alignment.Start)
            ) {
                // Row for Tips Image and Text
                Column(
                    modifier = Modifier.padding(top = 20.dp, start = 15.dp)
                ) {
                    // Tips Image
                    Image(
                        painter = painterResource(id = R.drawable.report),
                        contentDescription = null,
                        modifier = Modifier
                            .size(130.dp)
                            .padding(0.dp ,0.dp,0.dp ,0.dp)// Keeping original size
                            .clickable(onClick = onReportUserClick)
                    )
                    // Tips Text
                    Text(
                        text = "Report Incidents",
                        color = Color.White,
                        modifier = Modifier.padding(start = 10.dp),
                    fontWeight=FontWeight.Bold// Space between image and text
                    )
                }

                // Spacer for spacing between the columns
                Spacer(modifier = Modifier.width(20.dp)) // Adjust width as needed

                // Row for Group Image and Previous Incidents Text
                Column(
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    // Group Image
                    Image(
                        painter = painterResource(id = R.drawable.people),
                        contentDescription = null,
                        modifier = Modifier
                            .size(130.dp)
                            .padding(0.dp, 0.dp, 0.dp, 0.dp)// Keeping original size // Keeping original size
                            .clickable(onClick = onpriviousUserClick)
                            .align(Alignment.End)

                    )

                    Spacer(modifier = Modifier.height(0.dp))

                    // Previous Incidents Text
                    Text(
                        text = "Previous Incidents",
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp),
                        fontWeight=FontWeight.Bold// Space between image and text
                    )
                }
            }

//            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp)
                    .align(Alignment.Start)
                    .fillMaxWidth()
            ) {
                // Row for Tips Image and Text
                Column(
                    modifier = Modifier.padding(10.dp, 10.dp ,0.dp , 0.dp)
                ) {
                    // Tips Image
                    Image(
                        painter = painterResource(id = R.drawable.light),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp) // Keeping original size
                            .padding(0.dp , 0.dp , 0.dp , 0.dp)// Keeping original size
                            .clickable(onClick = onTipUserClick)
                            .offset(x = 20.dp)

                    )



                    // Tips Text
                    Text(
                        text = "Tips",
                        color = Color.White,
                        modifier = Modifier
                            .offset(y=15.dp)
                            .padding(start = 50.dp),
                        fontWeight=FontWeight.Bold// Space between image and text
                    )
                }

                // Spacer for spacing between the columns
                Spacer(modifier = Modifier.width(40.dp)) // Adjust width as needed

                // Row for Group Image and Previous Incidents Text
                Column(
                    modifier = Modifier.padding(top = 5.dp)
                ) {
                    // Group Image
                    Image(
                        painter = painterResource(id = R.drawable.phone),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .offset(x=10.dp)
                            .padding(0.dp, 0.dp, 0.dp, 0.dp)// Keeping original size
                            .clickable(onClick = onEmergencyClick)
                            .align(Alignment.End)
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    // Previous Incidents Text
                    Text(
                        text = "Emergency Contact",
                        color = Color.White,

                        modifier = Modifier
                            .offset(x=20.dp)
                            .padding(start = 10.dp),

                        fontWeight=FontWeight.Bold// Space between image and text
                    )
                }
            }

            Spacer(modifier = Modifier.height(3.dp))
            // Settings Texts
            Image(
                painter = painterResource(id = R.drawable.setting),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .padding(0.dp, 0.dp, 0.dp, 0.dp)
                    .offset(x = 45.dp)
                    .clickable(onClick = onSettingsUserClick)
                    .align(Alignment.Start)

            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Settings",
                color = Color.White,
                modifier = Modifier
                    .clickable(onClick = onSettingsUserClick)
                    .padding(start = 65.dp),
                fontWeight=FontWeight.Bold
            )
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













//
//@Preview(showBackground = true)
//@Composable
//fun user_home() {
//    Box(modifier = Modifier.fillMaxSize()) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color(0xFFCA7F7F))
//        ) {
//            TopAppBarr()
//
//            Spacer(modifier = Modifier.height(50.dp))
//
//            WelcomeText()
//            LazyColumn(
//                modifier = Modifier
//                    .height(400.dp) // Set the height you want
//                    .fillMaxWidth()
//                    .padding(top = 25.dp),
//            ) {
//                items(1) { index ->
//                    Row(
//                        horizontalArrangement = Arrangement.Center,
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//
//                            ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.report),
//                                contentDescription = "Report Incidents",
//                                modifier = Modifier.size(90.dp)
//                            )
//                            Text(text = "Report Incidents", color = Color.White) // Add text below the icon
//                        }
//                        Spacer(modifier = Modifier.width(60.dp))
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//
//                            ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.people),
//                                contentDescription = "previous Incidents",
//                                modifier = Modifier.size(90.dp)
//                            )
//                            Text(
//                                text = "previous Incidents",
//                                color = Color.White
//                            ) // Add text below the icon
//                        }
//                    }
//                    Row(
//                        horizontalArrangement = Arrangement.Center,
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//
//                            ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.light),
//                                contentDescription = "Tips",
//                                modifier = Modifier.size(80.dp)
//                            )
//                            Text(text = "Tip", color = Color.White) // Add text below the icon
//                        }
//                        Spacer(modifier = Modifier.width(62.dp))
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//
//
//                            ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.phone),
//                                contentDescription = "Emergency contact",
//                                modifier = Modifier.size(90.dp)
//                            )
//                            Text(
//                                text = "Emergency contact",
//                                color = Color.White
//                            ) // Add text below the icon
//                        }
//                    }
//                    Row(
//                        horizontalArrangement = Arrangement.Center,
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//
//                            ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.setting),
//                                contentDescription = "settings",
//                                modifier = Modifier.size(90.dp)
//                            )
//                            Text(text = "settings", color = Color.White) // Add text below the icon
//                        }
//                        Spacer(modifier = Modifier.width(170.dp))
//                    }
//                }
//            }
//        }
//
//        // Bottom Image positioned at the bottom center
//        Image(
//            painter = painterResource(id = R.drawable.rectangle),
//            contentDescription = null,
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .fillMaxWidth()
//                .height(235.dp) // Adjust height as needed
//                .padding(bottom = 0.dp)
//        )
//    }
//}
//@Composable
//fun WelcomeText() {
//    Box(
//        modifier = Modifier.padding(start = 100.dp),
//    ) {
//        Text(
//            text = "Welcome back user",
//            color = Color.White,
//            fontSize = 25.sp
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TopAppBarr(){
//    TopAppBar( modifier = Modifier.padding(top = 35.dp),
//
//        title = {
//            Row(verticalAlignment = Alignment.CenterVertically , modifier = Modifier.padding(start = 42.dp)) {
//                Image(
//                    painter = painterResource(id = R.drawable.logo),
//                    contentDescription = "setting icon",
//                    modifier = Modifier.size(90.dp)
//
//                )
//                Spacer(modifier = Modifier.width(10.dp))
//                Text("Neighbourhood Watch", color = Color.White, fontSize = 16.sp, style = MaterialTheme.typography.titleMedium)
//
//
//
//
//
//            }
//        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFCA7F7F))
//
//
//        )
//}
//



