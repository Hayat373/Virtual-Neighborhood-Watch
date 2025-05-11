package com.example.neighbourhood_watch

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.ViewModelProvider
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import com.example.neighborhood_watch.viewmodel.UserModel
import com.example.neighbourhood_watch.veiw.screen.SettingUser



class SettingsActivity : ComponentActivity() {
    private val userModel: UserModel by viewModels()


    private val currentUserId = 1
    // Replace with actual logic to get the current user ID
    private fun handleDeleteUser(currentUserId: Int) {
        Log.d("SettingsActivity", "Deleting user with ID: $currentUserId")

        userModel.deleteUser(currentUserId,
            onSuccess = {
                // Handle success
                startActivity(Intent(this@SettingsActivity, MainActivity::class.java))
                finish() // Close the current activity
            },
            onError = { errorMessage ->
                Toast.makeText(this, "Error: $errorMessage", Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun handleLogout() {
        // Implement your logout logic here
        startActivity(Intent(this@SettingsActivity, MainActivity::class.java))
        finish() // Close the current activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the UserModel

        setContent {
            MaterialTheme {
                Surface {
                    SettingUser(
                        onLogOutClick = { handleLogout() },
                        onDeletClick = { handleDeleteUser(currentUserId) },
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
}