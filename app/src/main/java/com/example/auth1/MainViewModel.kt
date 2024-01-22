package com.example.auth1

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    val firebase = FireBaseRepo()
    val profile = mutableStateOf(Profile())

    var name = mutableStateOf("")
    var age = mutableStateOf("")
    var mail = mutableStateOf("")
    var address = mutableStateOf("")

    var finalname = mutableStateOf("")
    var finalage = mutableStateOf("")
    var finalmail = mutableStateOf("")
    var finaladdress = mutableStateOf("")

    //var listOfUsers = mutableStateOf(listOf(Profile()))

    var submit = mutableStateOf(false)

    fun toSendData() {
        firebase.sendData(
            finalname.value,
            finalage.value,
            finalmail.value,
            finaladdress.value
        )
    }

}