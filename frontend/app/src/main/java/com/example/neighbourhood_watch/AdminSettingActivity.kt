package com.example.neighbourhood_watch

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.ViewModelProvider
import com.example.neighborhood_watch.viewmodel.UserModel
import com.example.neighbourhood_watch.AdminPreviousIncidentActivity
import com.example.neighbourhood_watch.AdminActivity
import com.example.neighbourhood_watch.AdminNavigationActivity
import com.example.neighbourhood_watch.AdminTipActivity
import com.example.neighbourhoodwatch.veiw.screen.Setting

class AdminSettingsActivity : ComponentActivity() {
    private lateinit var userModel: UserModel
    private val currentUserId = 1 // Replace with actual logic to get the current user ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the UserModel
        userModel = ViewModelProvider(this).get(UserModel::class.java)

        setContent {
            MaterialTheme {
                Surface {
                    Setting(
                        onLogOutClick = { handleLogout() },
                        onDeletClick = { handleDeleteUser(currentUserId) },
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
                        }                    )
                }
            }
        }
    }

    private fun handleLogout() {
        // Implement your logout logic here
        // For example, clear user session and navigate to login screen
        startActivity(Intent(this, MainActivity::class.java))
        finish() // Close the current activity
    }

    private fun handleDeleteUser(currentUserId: Int) {
        userModel.deleteUser(currentUserId,
            onSuccess = {
                // Handle success (e.g., show a message and navigate to login screen)
                startActivity(Intent(this, AdminActivity::class.java))
                finish() // Close the current activity
            },
            onError = { errorMessage ->
                // Handle error (e.g., show an error message)
                // You can use Toast or Snackbar to display the error
                // Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        )
    }
}