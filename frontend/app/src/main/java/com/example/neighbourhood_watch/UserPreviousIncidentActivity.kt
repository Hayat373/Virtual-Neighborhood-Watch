package com.example.neighbourhood_watch

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import com.example.neighbourhood_watch.veiw.screen.previousIncidentUser
import com.example.neighbourhood_watch.viewmodel.PreviousIncidentViewModel

class PreviousIncidentActivity : ComponentActivity() {
    private val previousIncidentViewModel: PreviousIncidentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // Fetch incidents when the screen is created
                previousIncidentViewModel.fetchIncidents()

                // Observe the incidents state and pass it to the screen
                val incidents = previousIncidentViewModel.incidents.value

                previousIncidentUser(
                    onMenuClick = { startActivity(Intent(this, NavigationActivity::class.java)) },
                    onTipUserClick = { startActivity(Intent(this, UserTipActivity::class.java)) },
                    onIncidentsUserClick = { startActivity(Intent(this, PreviousIncidentActivity::class.java)) },
                    onSettingsUserClick = { startActivity(Intent(this, SettingsActivity::class.java)) },
                    onReportClick = { startActivity(Intent(this, UserReportIncidentActivity::class.java)) },
                    onEmerencyClick = { startActivity(Intent(this, EmergencyActivity::class.java)) },
                    incidents = incidents // Pass the fetched incidents here
                )

            }
        }
    }
}

