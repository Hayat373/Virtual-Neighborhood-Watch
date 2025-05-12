package com.example.neighbourhood_watch.veiw.component


import android.os.Bundle
import android.content.Context
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log
import com.example.neighbourhood_watch.R
import com.example.neighbourhood_watch.api.RetrofitClientAdmin
import com.example.neighbourhood_watch.model.CreateTipDto


@Composable
fun AddTipDialog(
    context: Context, // Pass the Activity context
    onPostClick: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var tipText by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Add New Tip") },
        text = {
            Column(
                modifier = Modifier
                    .width(286.dp)
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Tip:",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .border(
                            BorderStroke(2.dp, Color(0xFF361919)),
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    TextField(
                        value = tipText,
                        onValueChange = { tipText = it },
                        placeholder = { Text("Enter your tip here") },
                        modifier = Modifier.fillMaxSize(),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (tipText.isNotBlank()) {
                        Log.d("AddTipDialog", "Attempting to post tip: $tipText")
                        val createTipDto =
                            CreateTipDto(description = tipText) // Use 'description' here
                        RetrofitClientAdmin.instance.createTip(createTipDto).enqueue(object : Callback<Void> {
                            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                                if (response.isSuccessful) {
                                    onPostClick(tipText) // Notify success and dismiss the dialog
                                    onDismiss()
                                } else {
                                    val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                                    Log.e("AddTipDialog", "Error: ${response.code()} - $errorMessage")
                                    Toast.makeText(context, "Error: ${response.code()} - $errorMessage", Toast.LENGTH_LONG).show()
                                }
                            }
                            override fun onFailure(call: Call<Void>, t: Throwable) {
                                Log.e("AddTipDialog", "Network error: ${t.message}")
                                Toast.makeText(context, "Network error: ${t.message}", Toast.LENGTH_LONG).show()
                            }
                        })
                    } else {
                        Toast.makeText(context, "Tip cannot be empty", Toast.LENGTH_SHORT).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF361919)
                )
            ) {
                Text(text = "Post")
            }
        },
        dismissButton = null // You can add a dismiss button if needed
    )
}



@Preview(showBackground = true)
@Composable
fun PreviewAddTipDialog() {
    AddTipDialog(
        context = ComponentActivity(), // Placeholder for preview, adapt as needed
        onPostClick = { /* Handle post action */ },
        onDismiss = { /* Handle dismiss action */ }
    )
}