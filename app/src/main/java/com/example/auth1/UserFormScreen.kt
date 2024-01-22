package com.example.auth1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
fun UserForm(mainviewmodel: MainViewModel, nav: NavHostController) {

    Column(

    ) {

        TopAppBar(
            title = { Text(text = "Profile") }, colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.LightGray
            )
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(value = mainviewmodel.name.value, onValueChange = {
                mainviewmodel.name.value = it
                mainviewmodel.finalname.value = mainviewmodel.name.value

            }, label = { Text(text = "Name") })

            TextField(value = mainviewmodel.age.value, onValueChange = {
                mainviewmodel.age.value = it
                mainviewmodel.finalage.value = mainviewmodel.age.value
            }, label = { Text(text = "Age") })


            TextField(value = mainviewmodel.finalmail.value,
                onValueChange = {

                },
                label = { Text(text = "Mail")}  )


            TextField(value = mainviewmodel.address.value, onValueChange = {
                mainviewmodel.address.value = it
                mainviewmodel.finaladdress.value = mainviewmodel.address.value
            }, label = { Text(text = "Address") })

            Spacer(modifier = Modifier.height(40.dp))



            Row (){

                Button(onClick = { mainviewmodel.submit.value = true
                    mainviewmodel.toSendData()
                }) {
                    Text(text = "Submit")
                }
                if(mainviewmodel.submit.value){
                    AlertDialog(
                        onDismissRequest = { mainviewmodel.submit.value = false },
                        confirmButton = {
                            Text(text = "OK",
                                modifier = Modifier.clickable {
                                    mainviewmodel.submit.value = false
                                })
                        }
                        , text =  { Text(text = "Submitted successfully!!") }
                    )
                }

                Spacer(modifier = Modifier.width(50.dp))

                Button(onClick = {
                    nav.navigate("MyProfileScreen")
                }) {
                    Text(text="View My Profile")
                }
            }


        }
    }
}