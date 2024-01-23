package com.example.auth1

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListOfUsers(mainviewmodel: MainViewModel, nav: NavHostController) {
    Column() {
        TopAppBar(title = {
            Text(text = "Chats")
            TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Green
            )
        })
        LazyColumn {
            mainviewmodel.listOfUsers = mainviewmodel.toGetData(mainviewmodel.finalmail.value)
            items(mainviewmodel.listOfUsers.value) {
                ProfileCard(it)
            }
        }
    }
}
@Composable
fun ProfileCard(profile: Profile) {
    Box {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column() {


                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Image"
                )
            }

            Column(
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Username: ${profile.name}")
                //modifier = Modifier.border()
                Text(text = "Gmail: ${profile.mail}")
                Button(onClick = { /*nav.navigate("")*/ }) {
                    Text(text = "Chat")
                }
            }
        }
        Divider(
            thickness = 2.dp,
            color = Color.Black
        )
    }
}