package com.example.neighbourhood_watch.veiw.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.neighbourhood_watch.api.RetrofitClientUser
import com.example.neighbourhood_watch.model.Incident

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AddIncidentDialog(
    context: Context,
    coroutineScope: CoroutineScope, // Pass CoroutineScope for API calls
    onSubmitClick: (String, String, String) -> Unit,
    onDismiss: () -> Unit
) {
    var incidentTitle by remember { mutableStateOf("") }
    var incidentDescription by remember { mutableStateOf("") }
    var incidentLocation by remember { mutableStateOf("") } // Keep track of selected location


    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Add New Incident") },
        text = {
            Column(
                modifier = Modifier
                    .width(450.dp)
                    .height(300.dp)
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Row() {
                    Text(
                        text = "Title:",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .border(
                                BorderStroke(2.dp, Color(0xFF361919)),
                                shape = RoundedCornerShape(8.dp)
                            )
                    ) {
                        TextField(
                            value = incidentTitle,
                            onValueChange = { incidentTitle = it },
                            placeholder = { Text(
                                text="Enter your title here",
                                fontSize = 12.sp,) },

                            modifier = Modifier.fillMaxSize(),
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row() {
                    Text(
                        text = "Description:",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
Box(
modifier = Modifier
.fillMaxWidth()
.height(70.dp)
.border(
    BorderStroke(2.dp, Color(0xFF361919)),
shape = RoundedCornerShape(8.dp)
)
) {
    TextField(
        value = incidentDescription,
        onValueChange = { incidentDescription = it },
        placeholder = { Text(
            text="Description here",
            fontSize = 12.sp,) },
        modifier = Modifier.fillMaxSize(),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
    )
}
}


// Location Dropdown
Locationadd { location ->
    incidentLocation = location // Update the location state
}

}
},
confirmButton = {
    Button(
        onClick = {
            if (incidentTitle.isNotBlank()) {
                val newIncident = Incident(
                    id = 0, // Temporary ID, adjust as needed
                    title = incidentTitle,
                    description = incidentDescription,
                    location = incidentLocation
                )

                // Call the API and handle the response
                coroutineScope.launch {
                    try {
                        val createdIncident = RetrofitClientUser.instance.createIncident(newIncident)
                        onSubmitClick(createdIncident.title, createdIncident.description, createdIncident.location)
                        onDismiss() // Dismiss the dialog after successful submission
                    } catch (e: Exception) {
                        Log.e("AddIncidentDialog", "Error creating incident: ${e.message}")
                        Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                Toast.makeText(context, "Title cannot be empty", Toast.LENGTH_SHORT).show()
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF361919)
        )
    ) {
        Text(text = "Submit")
    }
},
dismissButton = {
    Button(onClick = onDismiss,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF361919),
        )
    )

    {
        Text("Cancel")

    }
}
)
}