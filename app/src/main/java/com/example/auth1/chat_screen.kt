package com.example.auth1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Chat(mainviewmodel: MainViewModel, nav: NavHostController) {
    Column() {
        TopAppBar(title = {
            Text(text = "MyChat")
            TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Green
            )
        })
    }
    Column(
        verticalArrangement = Arrangement.Bottom
    ) {
        Row() {
            TextField(value = mainviewmodel.messagge.value,
                onValueChange = {
                    mainviewmodel.messagge.value = it

                },
                label = { Text(text = "message") }
            )
            Button(onClick = { mainviewmodel.sendMessage() }) {
                Text(text = "Send")
            }
        }
    }
}