package com.example.neighbourhood_watch.veiw.component

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



@Composable
fun Locationadd(onLocationSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedLocation by remember { mutableStateOf("Choose your location") }

    val locations = listOf("6 Kilo", "5 Kilo", "4 kilo", "sefere selam", "ldeta")

    Box(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .fillMaxWidth()
        .wrapContentSize(Alignment.TopStart)) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            shadowElevation = 4.dp,
            color = Color(0xFF361919),
            modifier = Modifier
                .clickable { expanded = true }
                .border(1.dp, Color.Gray, RoundedCornerShape(20.dp))
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = selectedLocation,
                    color = Color.White,
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )

                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dropdown Arrow",
                    tint = Color.White
                )
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            locations.forEach { location ->
                DropdownMenuItem(
                    text = { Text(location) },
                    onClick = {
                        selectedLocation = location
                        onLocationSelected(location) // Pass the selected location back

                        expanded = false
                    }
                )
            }
        }
    }
}