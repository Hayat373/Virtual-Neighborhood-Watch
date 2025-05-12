@file:JvmName("AppbaruserKt")

package com.example.neighbourhood_watch.veiw.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarPrivUser(
    onMenuClick: () -> Unit,
    onTipUserClick: () -> Unit,
    onIncidentsUserClick: () -> Unit,
    onSettingsUserClick: () -> Unit,
    onReportClick: () -> Unit,
    onEmergencncyClick:() -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.peopleicon),
                    contentDescription = "Light Bulb",
                    modifier = Modifier
                        .size(50.dp)


                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    "Privious Incident",
                    color = Color.White,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.weight(1f)) // Pushes the menu icon to the right

                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(60.dp)
                        .padding(end= 20.dp)
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
        offset = DpOffset(x = 500.dp, y = (200).dp)
    ) {
        navigationuser(



            onTipsUserClick  = { expanded=false
                onTipUserClick()
            },
            onIncidentsUserClick = { expanded= false
                onIncidentsUserClick()
            },
            onSettingsUserClick = { expanded = false
                onSettingsUserClick() },
            onEmergencyClick ={
                expanded = false
                onEmergencncyClick()
            },
            onReportClick={expanded = false
                onReportClick()
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarsettingUser(
    onMenuClick: () -> Unit,
    onTipUserClick: () -> Unit,
    onIncidentsUserClick: () -> Unit,
    onSettingsUserClick: () -> Unit,
    onReportClick: () -> Unit,
    onEmergencncyClick:() -> Unit
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
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    "settings",
                    color = Color.White,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.weight(1f)) // Pushes the menu icon to the right

                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end=10.dp)
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
        offset = DpOffset(x = 500.dp, y = (200).dp)
    ) {
        navigationuser (
            onTipsUserClick  = { expanded=false
                onTipUserClick()
            },
            onIncidentsUserClick = { expanded= false
                onIncidentsUserClick()
            },
            onSettingsUserClick = { expanded = false
                onSettingsUserClick() },
            onEmergencyClick ={
                expanded = false
                onEmergencncyClick()
            },
            onReportClick={expanded = false
                onReportClick()
            }

        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarUserReport(
    onMenuClick: () -> Unit,
    onTipUserClick: () -> Unit,
    onIncidentsUserClick: () -> Unit,
    onSettingsUserClick: () -> Unit,
    onReportClick: () -> Unit,
    onEmergencncyClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.reporticon),
                    contentDescription = "User Incident",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text("Report Incidents", color = Color.White,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.titleMedium)

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(60.dp)
                        .padding(end=20.dp)
                        .clickable { expanded = !expanded }
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF794747)),
    )

    // Dropdown Menu
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        offset = DpOffset(x = 500.dp, y = (200).dp)
    ) {
        navigationuser(
            onTipsUserClick = { expanded = false; onTipUserClick() },
            onIncidentsUserClick = { expanded = false; onIncidentsUserClick() },
            onSettingsUserClick = { expanded = false; onSettingsUserClick() },
            onEmergencyClick = { expanded = false; onEmergencncyClick() },
            onReportClick = { expanded = false; onReportClick() }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBaremergency(
    onMenuClick: () -> Unit,
    onTipUserClick: () -> Unit,
    onIncidentsUserClick: () -> Unit,
    onSettingsUserClick: () -> Unit,
    onReportClick: () -> Unit,
    onEmergencncyClick:() -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.phoneicon),
                    contentDescription = "Light Bulb",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    "Emergency Contact",
                    color = Color.White,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.weight(1f)) // Pushes the menu icon to the right

                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(50.dp)
                        .offset(x = -(20).dp)
                        .padding(end= 4.dp)
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
        offset = DpOffset(x = 500.dp, y = (200).dp)
    ) {
        navigationuser(



            onTipsUserClick  = { expanded=false
                onTipUserClick()
            },
            onIncidentsUserClick = { expanded= false
                onIncidentsUserClick()
            },
            onSettingsUserClick = { expanded = false
                onSettingsUserClick() },
            onEmergencyClick ={
                expanded = false
                onEmergencncyClick()
            },
            onReportClick={expanded = false
                onReportClick()
            }
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarUserTip(
    onMenuClick: () -> Unit,
    onTipUserClick: () -> Unit,
    onIncidentsUserClick: () -> Unit,
    onSettingsUserClick: () -> Unit,
    onReportClick: () -> Unit,
    onEmergencncyClick:() -> Unit
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
                Text(
                    "Tips",
                    color = Color.White,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.weight(1f)) // Pushes the menu icon to the right

                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(45.dp)
                        .offset(x = -(20).dp)
                        .padding(end= 3.dp)
                        .clickable { expanded = !expanded } // Toggle the menu
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF794747)),
    )
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        offset = DpOffset(x = 500.dp, y = (200).dp)
    ) {
        navigationuser(


            onTipsUserClick  = { expanded=false
                onTipUserClick()
            },
            onIncidentsUserClick = { expanded= false
                onIncidentsUserClick()
            },
            onSettingsUserClick = { expanded = false
                onSettingsUserClick() },
            onEmergencyClick ={
                expanded = false
                onEmergencncyClick()
            },
            onReportClick={expanded = false
                onReportClick()
            }
        )
    }
}