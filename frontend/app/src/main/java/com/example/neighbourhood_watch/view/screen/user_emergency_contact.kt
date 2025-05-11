package com.example.neighbourhood_watch.veiw.screen


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neighbourhood_watch.veiw.component.TopAppBaremergency

import com.example.neighbourhood_watch.R

@Composable
fun emergencyScreen(
    onMenuClick: () -> Unit,
    onTipUserClick: () -> Unit,
    OnIncidentsUserClick: () -> Unit,
    onSettingsUserClick: () -> Unit,
    onReportClick: () -> Unit,          // Add this line
    onEmerencyClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCA7F7F))
        ) {
            TopAppBaremergency( onMenuClick = onMenuClick,
                onTipUserClick= onTipUserClick,
                onIncidentsUserClick= OnIncidentsUserClick,
                onSettingsUserClick= onSettingsUserClick,
                onReportClick=onReportClick,
                onEmergencncyClick=onEmerencyClick)

            Spacer(modifier = Modifier.height(50.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                EmergencyCard(
                    icon = R.drawable.ambulance,
                    label = "Ambulance -944"
                )
                EmergencyCard(
                    icon = R.drawable.fire,
                    label = "Fire Department -922"
                )
                EmergencyCard(
                    icon = R.drawable.police,
                    label = "Police -991"
                )
            }
        }

        // Bottom Image positioned at the bottom center
        Image(
            painter = painterResource(id = R.drawable.rectangle),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(250.dp) // Adjust height as needed
                .padding(bottom = 0.dp)
        )
    }
}





@Composable
fun EmergencyCard(icon: Int, label: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()

            .clip(RoundedCornerShape(20.dp)) // Rounded corners
            .padding(vertical = 15.dp, horizontal = 20.dp), // Set background color
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp) // Elevation for shadow
    ) {
        Row(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .height(30.dp)
            , // Only padding, no background color
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp)) // Add space between image and text
            Text(
                text = label,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium // Use MaterialTheme for styling
            )
        }
    }
}

