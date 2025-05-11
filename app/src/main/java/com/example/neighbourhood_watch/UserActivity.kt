package com.example.neighbourhood_watch


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
import com.example.neighbourhood_watch.view.screen.user_home


class UserActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    user_home(
                        username = "Hayat",
                        onTipUserClick={ startActivity(Intent(this, UserTipActivity::class.java))} ,
                        onReportUserClick ={ startActivity(Intent( this, UserReportIncidentActivity::class.java))},
                        onpriviousUserClick= { startActivity( Intent ( this, PreviousIncidentActivity::class.java))},
                        onSettingsUserClick={ startActivity( Intent ( this, SettingsActivity::class.java))},
                        onEmergencyClick ={ startActivity( Intent ( this, EmergencyActivity::class.java))}
                    )
                }
            }
        }
    }
}