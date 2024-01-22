package com.example.auth1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyProfile(mainviewmodel:MainViewModel,nav: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.SpaceEvenly
    ) {

        TopAppBar(
            title = { Text(text = "My Profile") },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.LightGray
            )
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.height(300.dp)
        ) {


            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Name :  ")
                Text(mainviewmodel.finalname.value)
            }

            Divider(
                thickness = 2.dp,
                color = Color.Black
            )

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Age :  ")
                Text(mainviewmodel.finalage.value)
            }

            Divider(
                thickness = 2.dp,
                color = Color.Black
            )

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Mail :  ")
                Text(mainviewmodel.finalmail.value)
            }

            Divider(
                thickness = 2.dp,
                color = Color.Black
            )

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Address :  ")
                Text(mainviewmodel.finaladdress.value)
            }
            Divider(
                thickness = 2.dp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row() {
            Button(onClick = {

                nav.navigate("UserForm")

            }) {
                Text(text = "Back")
            }

            Spacer(modifier = Modifier.width(60.dp))

            Button(onClick = {
                nav.navigate("ListOfProfilesScreen")

            }) {
                Text(text = "View All Profiles..")
            }
        }
    }
}