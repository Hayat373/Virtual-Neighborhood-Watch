package com.example.neighbourhood_watch

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import com.example.neighbourhood_watch.veiw.screen.userreportincidentscreen
import com.example.neighbourhood_watch.viewmodel.UserReportViewModel


class UserReportIncidentActivity : ComponentActivity() {
    private val userReportViewModel: UserReportViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                userReportViewModel.fetchIncidents()

                val incidents = userReportViewModel.incidents.value

                userreportincidentscreen(
                    onMenuClick = { startActivity(Intent(this, NavigationActivity::class.java)) },
                    onTipUserClick = { startActivity(Intent(this, UserTipActivity::class.java)) },
                    OnIncidentsUserClick = { startActivity(Intent(this, PreviousIncidentActivity::class.java)) },
                    onSettingsUserClick = { startActivity(Intent(this, SettingsActivity::class.java)) },
                    onReportClick = { startActivity(Intent(this, UserReportIncidentActivity::class.java)) },
                    onEmerencyClick = { startActivity(Intent(this, EmergencyActivity::class.java)) },
                    incidents = incidents,
                    userReportViewModel = userReportViewModel
                )
            }
        }
    }
}