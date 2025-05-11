package com.example.neighbourhood_watch.veiw.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

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

import com.example.neighbourhood_watch.R
import com.example.neighbourhood_watch.view.component.admin_navigation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarPriv(
    onMenuClick: () -> Unit,
    onTipClick: () -> Unit,
    onIncidentsClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.peopleicon),
                    contentDescription = "Light Bulb",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    "Privious Incident",
                    color = Color.White,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.weight(1f)) // Pushes the menu icon to the right

                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(40.dp)
                        .offset(x = -(20).dp)
                        .clickable { expanded = !expanded } // Toggle the menu

                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF794747)),
    )

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarset(
    onMenuClick: () -> Unit,
    onTipClick: () -> Unit,
    onIncidentsClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.settingicon),
                    contentDescription = "Light Bulb",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    "settings",
                    color = Color.White,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.weight(1f)) // Pushes the menu icon to the right

                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(40.dp)
                        .offset(x = -(20).dp)
                        .clickable { expanded = !expanded } // Toggle the menu

                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF794747)),
    )
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipAppBar(
    onMenuClick: () -> Unit,
    onTipClick: () -> Unit,
    onIncidentsClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.lighticon),
                    contentDescription = "Light Bulb",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text("Tips", color = Color.White, fontSize = 16.sp, style = MaterialTheme.typography.titleMedium)

                Spacer(modifier = Modifier.weight(1f)) // Pushes the menu icon to the right

                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(40.dp)
                        .offset(x = -(20).dp)
                        .clickable { expanded = !expanded } // Toggle the menu

                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF794747)),
    )

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

