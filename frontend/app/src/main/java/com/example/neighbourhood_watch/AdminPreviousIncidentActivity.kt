package com.example.neighbourhood_watch



import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.neighbourhood_watch.AdminActivity
import com.example.neighbourhood_watch.viewmodel.IncidentViewModel
import com.example.neighbourhood_watch.AdminNavigationActivity
import com.example.neighbourhoodwatch.veiw.screen.priviousIncident


class AdminPreviousIncidentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    val incidentViewModel: IncidentViewModel = viewModel() // Initialize the ViewModel

                    priviousIncident(
                        onMenuClick = {
                            startActivity(Intent(this, AdminNavigationActivity::class.java)) // Navigate to NavigationActivity
                        },
                        onTipClick = {
                            startActivity(Intent(this, AdminActivity::class.java))
                        },
                        onIncidentsClick = {
                            startActivity(Intent(this, AdminPreviousIncidentActivity::class.java))
                        },
                        onSettingsClick = {
                            startActivity(Intent(this, AdminSettingsActivity::class.java))
                        },
                        incidentViewModel = incidentViewModel // Pass the ViewModel here
                    )
                }
            }
        }
    }
}