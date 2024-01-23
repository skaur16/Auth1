package com.example.auth1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.auth1.ui.theme.Auth1Theme
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainviewmodel: MainViewModel by viewModels()

        registerLoginLauncher()

        setContent {
            Auth1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {



                       NavScreens(mainviewmodel, ::launchLoginFlow)

                    }

                }
            }
        }


        // STEP 1:
        private lateinit var loginLauncher: ActivityResultLauncher<Intent>
        private fun registerLoginLauncher() {
            Log.d("TAG", "Inside setupLoginLauncher")
            loginLauncher =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult())
                { result: ActivityResult ->
                    Log.d("TAG", "Inside ActivityResult $result")
                    if (result.resultCode == Activity.RESULT_OK) {
                        Log.d("TAG", "Inside ResultLambda ")
                        loginHandler()
                    } else Toast.makeText(this, "Not able to Login, Try Again", Toast.LENGTH_SHORT)
                        .show()
                }
        }

        // Step 2: Launcher
        private fun launchLoginFlow(loginHandler: (() -> Unit)) {
            this.loginHandler = loginHandler

            val intent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(
                    listOf(
                        AuthUI.IdpConfig.GoogleBuilder().build()
                    )
                )
                .build()

            loginLauncher.launch(intent)
        }

        // Step 3: Handler (to get the result)
        private lateinit var loginHandler: (() -> Unit)


    }



@Composable
fun App(
    launcherLoginFlow: (() -> Unit) -> Unit,
    mainviewmodel: MainViewModel,
    nav: NavHostController
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Button(onClick = {

            launcherLoginFlow {
                val user = FirebaseAuth.getInstance().currentUser
                user?.let {
                    Log.e("TAG", "FirebaseAuth :- ${user.email}")
                    Log.e("TAG", "FirebaseAuth :- ${user.displayName}")
                    Log.e("TAG", "FirebaseAuth :- ${user.photoUrl}")
                    Log.e("TAG", "FirebaseAuth :- ${user.providerId}")
                    Log.e("TAG", "FirebaseAuth :- ${user.uid}")

                    Log.e("EMAIL BEFORE",mainviewmodel.finalmail.value)
                    mainviewmodel.finalmail.value = user.email.toString()
                    Log.e("EMAIL AFTER",mainviewmodel.finalmail.value)

                    Log.e("NAVHOST",mainviewmodel.navigation.value.toString())
                    nav.navigate("UserFormScreen")
                }


            }


        }) {
            Text(text = "Sign In")

        }
    }

}


@Composable
fun NavScreens(mainviewmodel: MainViewModel, loginLauncherFlow: (() -> Unit) -> Unit) {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = "login_screen" ){

        composable("login_screen"){ App(loginLauncherFlow, mainviewmodel,nav) }
        composable("UserFormScreen"){ UserForm(mainviewmodel , nav )}
        composable("MyProfileScreen"){ MyProfile(mainviewmodel , nav  )}
        composable("ListOfProfilesScreen"){ ListOfUsers(mainviewmodel , nav)}
        composable("chat_screen"){Chat(mainviewmodel,nav)}
    }
}




