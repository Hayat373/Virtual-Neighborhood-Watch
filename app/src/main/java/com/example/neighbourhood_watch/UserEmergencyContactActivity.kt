package com.example.neighbourhood_watch

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.core.content.ContextCompat.startActivity
import com.example.neighbourhood_watch.veiw.screen.emergencyScreen

class EmergencyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                emergencyScreen(
                    onMenuClick={ startActivity(Intent(this, NavigationActivity::class.java))},
                    onTipUserClick={ startActivity(Intent(this, UserTipActivity::class.java))},
                    OnIncidentsUserClick={ startActivity(Intent(this, PreviousIncidentActivity::class.java))},
                    onSettingsUserClick={ startActivity(Intent(this, SettingsActivity::class.java))},
                    onReportClick={ startActivity(Intent(this, UserReportIncidentActivity::class.java))},
                    onEmerencyClick={ startActivity(Intent(this, EmergencyActivity::class.java))}

                )
            }
        }
    }
}