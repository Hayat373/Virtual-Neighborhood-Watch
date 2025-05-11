package com.example.neighbourhood_watch.view.screen



import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.DpOffset
import com.example.neighbourhood_watch.R
import com.example.neighbourhood_watch.api.RetrofitClientAdmin
import com.example.neighbourhood_watch.model.EditTipDto
import com.example.neighbourhood_watch.veiw.component.AddTipDialog
import com.example.neighbourhood_watch.veiw.component.TipAppBar
import com.example.neighbourhood_watch.view.component.TipCardadmin
import com.example.neighbourhood_watch.view.component.admin_navigation
import com.example.neighbourhood_watch.viewmodel.TipViewModel



import retrofit2.Call
import retrofit2.Callback // Add this import if not present
import retrofit2.Response // Ensure this import is there


@Composable
fun AdminScreen(onMenuClick: () -> Unit,
                onTipClick: () -> Unit,
                onIncidentsClick: () -> Unit,
                onSettingsClick: () -> Unit ) {
    var showAddTipDialog by remember { mutableStateOf(false) }
    var editTipId by remember { mutableStateOf<Int?>(null) }
    var editTipDescription by remember { mutableStateOf("") }
    var showDeleteConfirmation by remember { mutableStateOf<Int?>(null) }
    val tipViewModel: TipViewModel = viewModel()
    var expanded by remember { mutableStateOf(false)}

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCA7F7F))        ) {
            TipAppBar(
                onMenuClick = onMenuClick,
                onTipClick = onTipClick,
                onIncidentsClick = onIncidentsClick,
                onSettingsClick = onSettingsClick
            )

            Spacer(modifier = Modifier.height(50.dp))

            val tips by tipViewModel.tips

            LazyColumn(
                modifier = Modifier
                    .height(500.dp)
                    .fillMaxWidth()
            ) {
                items(tips) { tip ->
                    TipCardadmin(
                        tip = tip.description,
                        id = tip.id,

                        onEditTip = { id ->
                            editTipId = id
                            editTipDescription = tip.description
                        },
                        onDeleteTip = { id ->
                            showDeleteConfirmation = id
                        }
                    )
                }
            }

            // Show Edit Dialog
            if (editTipId != null) {
                AlertDialog(
                    onDismissRequest = { editTipId = null },
                    title = { Text("Edit Tip") },
                    text = {
                        TextField(
                            value = editTipDescription,
                            onValueChange = { editTipDescription = it },
                            label = { Text("Description") }
                        )
                    },
                    confirmButton = {
                        Button(onClick = {
                            val editTipDto = EditTipDto(description = editTipDescription)
                            RetrofitClientAdmin.apiService.editTip(editTipId!!, editTipDto).enqueue(object : Callback<Void> {
                                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                                    if (response.isSuccessful) {
                                        Log.d("AdminScreen", "Tip edited successfully")
                                    } else {
                                        Log.e("AdminScreen", "Error editing tip: ${response.code()}")
                                    }
                                    editTipId = null // Close dialog
                                }

                                override fun onFailure(call: Call<Void>, t: Throwable) {
                                    Log.e("AdminScreen", "Error: ${t.localizedMessage}")
                                }
                            })
                        },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF361919)
                            )
                        ) {
                            Text("Save")
                        }
                    },
                    dismissButton = {
                        Button(onClick = { editTipId = null },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF361919)
                            )) {
                            Text("Cancel")
                        }
                    }
                )
            }

            // Confirm Delete Dialog
            if (showDeleteConfirmation != null) {
                AlertDialog(
                    onDismissRequest = { showDeleteConfirmation = null },
                    title = { Text("Delete Tip") },
                    text = { Text("Are you sure you want to delete this tip?") },
                    confirmButton = {
                        Button(onClick = {
                            RetrofitClientAdmin.apiService.deleteTip(showDeleteConfirmation!!).enqueue(object : Callback<Void> {
                                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                                    if (response.isSuccessful) {
                                        Log.d("AdminScreen", "Tip deleted successfully")
                                    } else {
                                        Log.e("AdminScreen", "Error deleting tip: ${response.code()}")
                                    }
                                    showDeleteConfirmation = null // Close dialog
                                }
                                override fun onFailure(call: Call<Void>, t: Throwable) {
                                    Log.e("AdminScreen", "Error: ${t.localizedMessage}")
                                }
                            })
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
                    .padding(bottom = 100.dp, start = 250.dp)
                    .offset(y = 100.dp)

                    .align(Alignment.CenterHorizontally)
                    .size(50.dp)
                    .clickable { showAddTipDialog = true }
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
                .clickable { showAddTipDialog = true }
        )

        // Show Add Tip Dialog
        if (showAddTipDialog) {
            val context = LocalContext.current
            AddTipDialog(
                context = context,
                onPostClick = { tip ->
                    showAddTipDialog = false
                },
                onDismiss = {
                    showAddTipDialog = false
                }
            )
        }

        // Dropdown Menu


        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(x = 500.dp, y = (300).dp)
        ) {
            admin_navigation(
                onTipClick = {
                    expanded = false // Close the menu after clicking
                    onTipClick() // Handle Tips navigation
                },
                onIncidentsClick = {
                    expanded = false // Close the menu after clicking
                    onIncidentsClick() // Handle Previous Incidents navigation
                },
                onSettingsClick = {
                    expanded = false // Close the menu after clicking
                    onSettingsClick() // Handle Settings navigation
                }

            )
        }
    }

    }









@Preview(showBackground = true)
@Composable
fun AdminScreenPriv() {
    AdminScreen(
        onMenuClick = { /* Handle menu click */ },
        onTipClick = { /* Handle Tips navigation */ },
        onIncidentsClick = { /* Handle Previous Incidents navigation */ },
        onSettingsClick = { /* Handle Settings navigation */ }
    ) // Preview the AdminScreen
}