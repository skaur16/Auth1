package com.example.auth1

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

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

    var listOfUsers = mutableStateOf(listOf(Profile()))

    var submit = mutableStateOf(false)

    var navigation = mutableStateOf(false)

    fun toSendData() {
        firebase.sendData(
            finalname.value,
            finalage.value,
            finalmail.value,
            finaladdress.value
        )
    }

    fun toGetData(mail:String): MutableState<List<Profile>> {
        viewModelScope.launch {
            Log.e("LIST", listOfUsers.toString())
            firebase.getUserData(mail).also {
                if (it != null) {
                    listOfUsers.value = it
                    Log.e("LIST", listOfUsers.toString())
                }

            }

        }
        return listOfUsers

    }

}