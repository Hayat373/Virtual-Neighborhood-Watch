package com.example.neighbourhood_watch.veiw.screen

import com.example.neighbourhood_watch.R




import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import com.example.neighbourhood_watch.veiw.component.navigationuser





@Composable
fun SettingUser(
    onLogOutClick: () -> Unit,
    onDeletClick: () -> Unit,
    onMenuClick: () -> Unit,
    onTipUserClick: () -> Unit,
    OnIncidentsUserClick: () -> Unit,
    onSettingsUserClick: () -> Unit,
    onReportClick: () -> Unit,
    onEmerencyClick: () -> Unit

) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCA7F7F))
        ) {
            TopAppBarsettingUser (
                onMenuClick = onMenuClick,
                onTipUserClick= onTipUserClick,
                onIncidentsUserClick= OnIncidentsUserClick,
                onSettingsUserClick= onSettingsUserClick,
                onReportClick=onReportClick,
                onEmergencncyClick=onEmerencyClick
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
                        .padding(top = 16.dp, start=40.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logout),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .clickable(onClick = onLogOutClick)
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Log Out",
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 27.dp, ),
                        fontWeight = FontWeight.Bold
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
                            .clickable {
                                Log.d("SettingsActivity", "Image clicked")
                                onDeletClick()
                            }                            .align(Alignment.End)
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Delete Account",
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 16.dp),
                        fontWeight = FontWeight.Bold
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
                        .size(60.dp)
                        .padding(end=20.dp)
                        .clickable { expanded = !expanded } // Toggle the menu

                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF794747)),
// Replace with your desired hex
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



