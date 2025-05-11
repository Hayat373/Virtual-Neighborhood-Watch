package com.example.neighbourhoodwatch.veiw.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import com.example.neighbourhood_watch.R
import com.example.neighbourhood_watch.veiw.component.TopAppBarset

@Composable
fun Setting(
    onLogOutClick: () -> Unit,
    onDeletClick: () -> Unit,
    onMenuClick: () -> Unit,
    onTipClick: () -> Unit,
    onIncidentsClick: () -> Unit,
    onSettingsClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCA7F7F)) // your background color
        ) {
            TopAppBarset(
                onMenuClick = onMenuClick,
                onTipClick = onTipClick,
                onIncidentsClick = onIncidentsClick,
                onSettingsClick = onSettingsClick
            ) // Pass the navigation callback

            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier
                    .padding(30.dp)
                    .align(Alignment.Start)
            ) {
                // Log Out Option
                Column(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 40.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logout),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .clickable(onClick = onLogOutClick)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Log Out",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 27.dp)
                    )
                }

                Spacer(modifier = Modifier.width(50.dp)) // Adjust width as needed

                // Delete Account Option
                Column(
                    modifier = Modifier
                        .padding(top = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.remove),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .clickable(onClick = onDeletClick)
                            .align(Alignment.End)
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Delete Account",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 16.dp)
                    )
                }
            }
        }

        // Bottom Image positioned at the bottom center
        Image(
            painter = painterResource(id = R.drawable.rectangle),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(250.dp)
                .padding(bottom = 0.dp)
        )
    }
}