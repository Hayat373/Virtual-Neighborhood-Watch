package com.example.neighbourhoodwatch.veiw.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.neighbourhood_watch.viewmodel.IncidentViewModel

import com.example.neighbourhood_watch.R
import com.example.neighbourhood_watch.veiw.component.LocationDropdown
import com.example.neighbourhood_watch.veiw.component.TopAppBarPriv
import com.example.neighbourhood_watch.view.component.PrivTipCardadmin


@Composable
fun priviousIncident(
    onMenuClick: () -> Unit,
    onTipClick: () -> Unit,
    onIncidentsClick: () -> Unit,
    onSettingsClick: () -> Unit,
    incidentViewModel: IncidentViewModel
) {
    val incidents by incidentViewModel.incidents // Observe incidents
    var selectedLocation by remember { mutableStateOf("Choose your location") } // State for selected location
    // Initialize with all incidents
    var filteredIncidents by remember { mutableStateOf(incidents) }


    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCA7F7F)) // your background color
        ) {
            TopAppBarPriv(
                onMenuClick = onMenuClick,
                onTipClick = onTipClick,
                onIncidentsClick = onIncidentsClick,
                onSettingsClick = onSettingsClick
            ) // Pass the navigation callback

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
                    .height(480.dp) // Set the height you want
                    .fillMaxWidth()
            ) {
                items(incidents) { incident -> // Use items directly
                    Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {

                        PrivTipCardadmin(
                            index = incidents.indexOf(incident) + 1, // Pass the index here
                            title = "Title: ${incident.title}",
                            description = "Description: ${incident.description}",
                            location = "Location: ${incident.location}"
                        )

                    }
                }
            }
        }
        // Bottom Image positioned at the bottom center, outside the Column
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