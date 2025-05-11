package com.example.neighbourhood_watch



import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.neighbourhood_watch.veiw.component.navigationuser



class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    navigationuser(
                        onTipsUserClick  = { /* Do nothing for preview */ },
                        onIncidentsUserClick = { /* Do nothing for preview */ },
                        onSettingsUserClick = { /* Do nothing for preview */ },
                        onEmergencyClick ={},
                        onReportClick={}
                    )
                }
            }
        }
    }
}