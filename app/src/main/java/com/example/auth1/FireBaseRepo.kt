package com.example.auth1

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FireBaseRepo {
    val db = Firebase.firestore

    fun sendData(
        name : String,
        age  : String,
        mail : String,
        address : String
    ){

       /* val profile = Profile(
            name, age, mail, address,

            )
         val sendHash = hashMapOf(
                         "Name" to name,
                         "Age" to age,
                         "Mail" to mail,
                         "Address" to address
          )

        db.collection("Users")
            .document(mail.toString())
            .set(profile)
    }

    suspend fun getUserData(mail:String): List<Profile> {
        return  db.collection("Users")
            .get()
            .await()
            .toObjects(Profile::class.java)

*/
    }


}