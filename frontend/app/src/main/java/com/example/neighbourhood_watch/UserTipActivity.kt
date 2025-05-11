package com.example.neighbourhood_watch

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import com.example.neighbourhood_watch.veiw.screen.userTipScreen
import com.example.neighbourhood_watch.viewmodel.TipsViewModel


class UserTipActivity : ComponentActivity() {
    private val tipsViewModel: TipsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // Fetch tips when the screen is created
                tipsViewModel.fetchTips()

                // Observe the tips state and pass it to the screen
                val tips = tipsViewModel.tips.value

                userTipScreen(
                    onMenuClick = { startActivity(Intent(this, NavigationActivity::class.java)) },
                    onTipUserClick = { startActivity(Intent(this, UserTipActivity::class.java)) },
                    OnIncidentsUserClick = { startActivity(Intent(this, PreviousIncidentActivity::class.java)) },
                    onSettingsUserClick = { startActivity(Intent(this, SettingsActivity::class.java)) },
                    onReportClick = { startActivity(Intent(this, UserReportIncidentActivity::class.java)) },
                    onEmerencyClick = { startActivity(Intent(this, EmergencyActivity::class.java)) },
                    tips = tips // Pass the tips here
                )
            }
        }
    }
}