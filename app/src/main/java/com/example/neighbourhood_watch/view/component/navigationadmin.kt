package com.example.neighbourhood_watch.view.component


import com.example.neighbourhood_watch.R



import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun admin_navigation(onTipClick: () -> Unit, onIncidentsClick: () -> Unit, onSettingsClick: () -> Unit) {
    Column(
        modifier = Modifier
            .width(250.dp)
            .padding(10.dp)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Tips",
            color = Color(0xFF361919),
            fontSize = 18.sp,
            modifier = Modifier
                .clickable(onClick = onTipClick)

        )

        Text(
            text = "Previous Incidents",
            color = Color(0xFF361919),
            fontSize = 18.sp,
            modifier = Modifier
                .clickable(onClick = onIncidentsClick)
        )

        Text(
            text = "Settings",
            color = Color(0xFF361919),
            fontSize = 18.sp,
            modifier = Modifier
                .clickable(onClick = onSettingsClick)
        )
    }
}
