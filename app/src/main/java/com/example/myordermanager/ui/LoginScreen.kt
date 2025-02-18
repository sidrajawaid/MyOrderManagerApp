package com.example.myordermanager.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import kotlinx.serialization.Serializable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myordermanager.ui.theme.AppTheme

@Suppress("NAME_SHADOWING")
@Serializable
class LoginWork {

    companion object {

        @Composable
        fun LoginScreen(param: String) {

            var text by remember { mutableStateOf(param) }
            var text1 by remember { mutableStateOf(param) }

            AppTheme {
              //  Surface {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxWidth()
                            .wrapContentHeight(Alignment.CenterVertically)
                            .padding(24.dp)
                            .background(Color.White)
                            .padding(16.dp),
                    ) {
                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp,
                                ),
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                OutlinedTextField(
                                    value = text,
                                    onValueChange = { text = it },
                                    label = { Text("username") })

                                OutlinedTextField(
                                    value = text1,
                                    onValueChange = { text1 = it },
                                    label = { Text("password") },
                                    textStyle = MaterialTheme.typography.headlineMedium
                                )

                                ElevatedButton(
                                    onClick = { onClick() }
                                ) {
                                    Text("Login")

                                }


                                var text by remember { mutableStateOf("") }
                                val brush = remember {
                                    Brush.sweepGradient(
                                        colors = listOf(Color.Red, Color.Cyan, Color.Blue)
                                    )
                                }
                                TextField(
                                    value = text,
                                    onValueChange = { text = it },
                                    textStyle = TextStyle(brush = brush)
                                )

                                Text(
                                    text = "Hello !",
                                    style = MaterialTheme.typography.titleLarge
                                )
                            }
                        }
                    }
               // }
            }
        }

       private fun  onClick(){}


        @Preview
        @Composable
        internal fun PreviewLoginScreen() {
            LoginScreen("hello")
        }
    }
}

