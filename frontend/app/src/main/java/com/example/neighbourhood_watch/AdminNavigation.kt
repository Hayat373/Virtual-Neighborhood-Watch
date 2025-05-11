package com.example.neighbourhood_watch


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.neighbourhood_watch.AdminPreviousIncidentActivity
import com.example.neighbourhood_watch.AdminSettingsActivity
import com.example.neighbourhood_watch.view.component.admin_navigation
import com.example.neighbourhood_watch.AdminTipActivity


class AdminNavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    admin_navigation(
                        onTipClick = { startActivity(Intent(this, AdminTipActivity::class.java)) },
                        onIncidentsClick = {  startActivity(Intent(this, AdminPreviousIncidentActivity::class.java)) },
                        onSettingsClick = { startActivity(Intent(this, AdminSettingsActivity::class.java))  }
                    )
                }
            }
        }
    }
}