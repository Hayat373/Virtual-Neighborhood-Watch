package com.example.neighbourhood_watch.veiw.screen



import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.neighbourhood_watch.model.Incident

import com.example.neighbourhood_watch.R
import com.example.neighbourhood_watch.veiw.component.LocationDropdown
import com.example.neighbourhood_watch.veiw.component.PrivTipCard
import com.example.neighbourhood_watch.veiw.component.TopAppBarPrivUser

//import com.example.neighborhooduser.view.screens.AdminActivity
//import com.example.neighborhooduser.view.screens.SettingsActivity
//import com.example.neighborhooduser.viewmodel.IncidentViewModel


@Composable
fun previousIncidentUser(
    onMenuClick: () -> Unit,
    onTipUserClick: () -> Unit,
    onIncidentsUserClick: () -> Unit,
    onSettingsUserClick: () -> Unit,
    onReportClick: () -> Unit,
    onEmerencyClick: () -> Unit,
    incidents: List<Incident>
) {
    var selectedLocation by remember { mutableStateOf("Choose your location") } // State for selected location
    // Initialize with all incidents
    var filteredIncidents by remember { mutableStateOf(incidents) } // State for filtered incidents

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCA7F7F))
        ) {
            TopAppBarPrivUser(
                onMenuClick = onMenuClick,
                onTipUserClick = onTipUserClick,
                onIncidentsUserClick = onIncidentsUserClick,
                onSettingsUserClick = onSettingsUserClick,
                onReportClick = onReportClick,
                onEmergencncyClick = onEmerencyClick
            )

            Spacer(modifier = Modifier.height(50.dp))
            LocationDropdown { location ->
                selectedLocation = location // Update the selected location
                // Filter incidents based on the selected location
                filteredIncidents = if (location == "Choose your location") {
                    incidents // Show all incidents if no specific location is selected
                } else {
                    incidents.filter { it.location == location } // Filter incidents
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)

            ) {
                items(filteredIncidents) { incident ->
                    PrivTipCard(
                        index = incidents.indexOf(incident) + 1,
                        title = "Title: ${incident.title}",
                        description = "Description: ${incident.description}",
                        location = "Location: ${incident.location}"
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