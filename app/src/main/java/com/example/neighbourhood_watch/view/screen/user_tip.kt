package com.example.neighbourhood_watch.veiw.screen


import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // Import this
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx. activity. ComponentActivity
import android. os. Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.DropdownMenu
import androidx.compose.ui.unit.DpOffset

import androidx.activity.viewModels
import com.example.neighbourhood_watch.R
import com.example.neighbourhood_watch.model.Tip
import com.example.neighbourhood_watch.veiw.component.TopAppBarUserTip
import com.example.neighbourhood_watch.veiw.component.userTipCard





@Composable
fun userTipScreen(
    onMenuClick: () -> Unit,
    onTipUserClick: () -> Unit,
    OnIncidentsUserClick: () -> Unit,
    onSettingsUserClick: () -> Unit,
    onReportClick: () -> Unit,          // Add this line
    onEmerencyClick: () -> Unit,
    tips: List<Tip> // Accept tips as a parameter
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCA7F7F))
        ) {
            TopAppBarUserTip(onMenuClick = onMenuClick,
                onTipUserClick= onTipUserClick,
                onIncidentsUserClick= OnIncidentsUserClick,
                onSettingsUserClick= onSettingsUserClick,
                onReportClick=onReportClick,
                onEmergencncyClick=onEmerencyClick)

            Spacer(modifier = Modifier.height(50.dp))


            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(tips) { tip ->
                    userTipCard(label = tip.description) // Use the description from the tip
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
                .height(250.dp) // Adjust height as needed
                .padding(bottom = 0.dp)
        )
    }
}