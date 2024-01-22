package com.example.auth1

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun ListOfUsers(mainviewmodel: MainViewModel, nav: NavHostController) {
    LazyColumn{
        mainviewmodel.listOfUsers = mainviewmodel.toGetData(mainviewmodel.finalmail.value)
        items(mainviewmodel.listOfUsers.value.size){
            Text(text = "User : ${mainviewmodel.listOfUsers.value}" )
        }
    }
}