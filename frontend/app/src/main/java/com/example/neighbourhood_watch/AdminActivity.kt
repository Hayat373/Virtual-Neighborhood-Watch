package com.example.neighbourhood_watch

import com.example.neighbourhood_watch.view.screen.admin_home


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neighbourhood_watch.AdminPreviousIncidentActivity
import com.example.neighbourhood_watch.AdminSettingsActivity
import com.example.neighbourhood_watch.AdminTipActivity


class AdminActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    admin_home(

                        onTipClick = { startActivity(Intent(this, AdminTipActivity::class.java)) },
                        onIncidentsClick = { startActivity(Intent(this, AdminPreviousIncidentActivity::class.java)) },
                        onSettingsClick = { startActivity(Intent(this, AdminSettingsActivity::class.java)) }
                    )
                }
            }
        }
    }
}