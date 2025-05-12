package com.example.neighbourhood_watch.veiw.component





import com.example.neighbourhood_watch.R



import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
fun navigationuser(onReportClick: () -> Unit,
                   onTipsUserClick: () -> Unit,
                   onIncidentsUserClick: () -> Unit,
                   onEmergencyClick: () -> Unit,
                   onSettingsUserClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .width(250.dp)
            .padding(10.dp)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Report Incidents",
            color=  Color(0xFF361919),
            fontSize = 18.sp,
            modifier = Modifier
                .clickable(onClick = onReportClick)

        )

        Text(
            text = "Previous Incidents",
            color=  Color(0xFF361919),
            fontSize = 18.sp,
            modifier = Modifier
                .clickable(onClick = onIncidentsUserClick)
        )

        Text(
            text = "Tips",
            color=  Color(0xFF361919),
            fontSize = 18.sp,
            modifier = Modifier
                .clickable(onClick = onTipsUserClick)
        )

        Text(
            text = "Emergency Contact",
            color=  Color(0xFF361919),
            fontSize = 18.sp,
            modifier = Modifier
                .clickable(onClick = onEmergencyClick)
        )

        Text(
            text = "Settings",
            color= Color(0xFF361919),
            fontSize = 18.sp,
            modifier = Modifier
                .clickable(onClick = onSettingsUserClick)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavigationUser() {
    MaterialTheme {
        // Dummy click handlers for preview
        navigationuser(
            onTipsUserClick  = { /* Do nothing for preview */ },
            onIncidentsUserClick = { /* Do nothing for preview */ },
            onSettingsUserClick = { /* Do nothing for preview */ },
            onEmergencyClick ={},
            onReportClick={}

        )
    }
}