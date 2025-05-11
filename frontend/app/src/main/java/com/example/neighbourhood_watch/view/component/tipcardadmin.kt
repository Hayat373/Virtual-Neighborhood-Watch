package com.example.neighbourhood_watch.view.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neighbourhood_watch.R

@Composable
fun TipCardadmin(
    tip: String,
    id: Int,
    onEditTip: (Int) -> Unit, // Expecting an Int parameter
    onDeleteTip: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .padding(horizontal = 20.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = tip,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Pass the id to onEditTip
                IconButton(onClick = { onEditTip(id) }) {
                    Image(
                        painter = painterResource(id = R.drawable.edit),
                        contentDescription = "Edit Tip",
                        modifier = Modifier.size(18.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                // Pass the id to onDeleteTip
                IconButton(onClick = { onDeleteTip(id) }) {
                    Image(
                        painter = painterResource(id = R.drawable.delete),
                        contentDescription = "Delete Tip",
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}