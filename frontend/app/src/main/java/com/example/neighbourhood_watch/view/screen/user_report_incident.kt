package com.example.neighbourhood_watch.veiw.screen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset

import com.example.neighbourhood_watch.viewmodel.UserReportViewModel
import com.example.neighbourhood_watch.R
import com.example.neighbourhood_watch.model.Incident
import com.example.neighbourhood_watch.veiw.component.AddIncidentDialog
import com.example.neighbourhood_watch.veiw.component.IncidentCard
import com.example.neighbourhood_watch.veiw.component.TopAppBarUserReport
import kotlinx.coroutines.coroutineScope

@Composable
fun userreportincidentscreen(
    onMenuClick: () -> Unit,
    onTipUserClick: () -> Unit,
    OnIncidentsUserClick: () -> Unit,
    onSettingsUserClick: () -> Unit,
    onReportClick: () -> Unit,
    onEmerencyClick: () -> Unit,
    incidents: List<Incident>,
    userReportViewModel: UserReportViewModel
) {
    var showAddIncidentDialog by remember { mutableStateOf(false) }
    var editIncidentId by remember { mutableStateOf<Int?>(null) }
    var editIncidentDescription by remember { mutableStateOf("") }
    var editIncidentLocation by remember { mutableStateOf("") }
    var editIncidentTitle by remember { mutableStateOf("") }
    var showDeleteConfirmation by remember { mutableStateOf<Int?>(null) }
    val coroutineScope = rememberCoroutineScope() // Create a coroutine scope


    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCA7F7F))
        ) {
            TopAppBarUserReport(
                onMenuClick = onMenuClick,
                onTipUserClick = onTipUserClick,
                onIncidentsUserClick = OnIncidentsUserClick,
                onSettingsUserClick = onSettingsUserClick,
                onReportClick = onReportClick,
                onEmergencncyClick = onEmerencyClick
            )

            Spacer(modifier = Modifier.height(50.dp))

            LazyColumn(
                modifier = Modifier
                    .height(500.dp)
                    .fillMaxWidth()
            ) {
                items(incidents) { incident ->
                    IncidentCard(
                        title = incident.title,
                        description = incident.description,
                        location = incident.location,
                        id = incident.id,
                        onEditIncident = { id ->
                            editIncidentId = id
                            editIncidentTitle = incident.title
                            editIncidentDescription = incident.description
                            editIncidentLocation = incident.location
                        },
                        onDeleteIncident = { id ->
                            showDeleteConfirmation = id
                        }
                    )
                }
            }
            // Show Edit Dialog
            if (editIncidentId != null) {
                AlertDialog(
                    onDismissRequest = { editIncidentId = null },
                    title = { Text("Edit Incident") },
                    text = {
                        Column {
                            TextField(
                                value = editIncidentDescription,
                                onValueChange = { editIncidentDescription = it },
                                label = { Text("Description") }
                            )

                            TextField(
                                value = editIncidentLocation,
                                onValueChange = { editIncidentLocation = it },
                                label = { Text("Location") }
                            )
                            TextField(
                                value = editIncidentTitle,
                                onValueChange = { editIncidentTitle = it },
                                label = { Text("Title") }
                            )
                        }
                    },
                    confirmButton = {
                        Button(onClick = {
                            // Create an Incident object with updated values
                            val updatedIncident = Incident(
                                id = editIncidentId!!,
                                title = editIncidentTitle,
                                description = editIncidentDescription,
                                location = editIncidentLocation
                            )

                            // Call the update function
                            userReportViewModel.updateIncident(updatedIncident.id, updatedIncident)

                            // Reset the edit state
                            editIncidentId = null
                            editIncidentDescription = ""
                            editIncidentLocation = ""
                            editIncidentTitle = ""
                        },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF361919)
                            )
                        ) {
                            Text("Save")
                        }
                    },
                    dismissButton = {
                        Button(onClick = { editIncidentId = null },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF361919)
                            )
                        ) {
                            Text("Cancel")
                        }
                    }
                )
            }
            // Confirm Delete Dialog
            if (showDeleteConfirmation != null) {
                AlertDialog(
                    onDismissRequest = { showDeleteConfirmation = null },
                    title = { Text("Delete Incident") },
                    text = { Text("Are you sure you want to delete this incident?") },
                    confirmButton = {
                        Button(onClick = {
                            userReportViewModel.deleteIncident(showDeleteConfirmation!!)
                            showDeleteConfirmation = null
                        },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF361919)
                            )
                        ) {
                            Text("Yes")
                        }
                    },
                    dismissButton = {
                        Button(onClick = { showDeleteConfirmation = null },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF361919)
                            )
                        ) {
                            Text("No")
                        }
                    }
                )
            }

            Image(
                painter = painterResource(id = R.drawable.add),
                contentDescription = "Add Icon",
                modifier = Modifier
                    .padding(bottom = 16.dp, start = 250.dp, top = 100.dp)
                    .align(Alignment.CenterHorizontally)
                    .size(50.dp)
                    .clickable { showAddIncidentDialog = true }
            )
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
                .clickable { showAddIncidentDialog = true }
        )

        // Show Add Incident Dialog
        if (showAddIncidentDialog) {
            val context = LocalContext.current
            AddIncidentDialog(
                context = context,
                coroutineScope = coroutineScope, // Ensure you have a coroutine scope

                onSubmitClick = { title, description, location ->
                    // Create a new incident object
                    val newIncident = Incident(
                        id = 0, // Set a temporary ID or handle ID generation on the server
                        title = title,
                        description = description,
                        location = location
                    )

                    // Call the ViewModel to create the incident
                    userReportViewModel.createIncident(newIncident)

                    // Dismiss the dialog
                    showAddIncidentDialog = false
                },
                onDismiss = {
                    showAddIncidentDialog = false
                }
            )
        }
    }
}