package com.example.neighbourhood_watch

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.neighbourhood_watch.AdminPreviousIncidentActivity
import com.example.neighbourhood_watch.AdminSettingsActivity
import com.example.neighbourhood_watch.AdminNavigationActivity
import com.example.neighbourhood_watch.view.screen.AdminScreen
class AdminTipActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    AdminScreen(
                        onMenuClick = {
                            startActivity(Intent(this, AdminNavigationActivity::class.java))
                        },
                        onTipClick = {
                            startActivity(Intent(this, AdminTipActivity::class.java))
                        },
                        onIncidentsClick = {
                            startActivity(Intent(this, AdminPreviousIncidentActivity::class.java))
                        },
                        onSettingsClick = {
                            startActivity(Intent(this, AdminSettingsActivity::class.java))
                        }
                    ) // Set AdminScreen as the content of the activity
                }
            }
        }
    }
}