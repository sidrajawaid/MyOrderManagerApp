package com.example.myordermanager.NavigationRoute

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myordermanager.ui.LoginWork
import com.example.myordermanager.ui.LoginWork.Companion.LoginScreen
import kotlinx.serialization.Serializable





@Serializable
object Login


@Serializable
object Splash


@Composable
fun Route() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> { LoginScreen("") }
        composable<Splash> { SplashScreen( /* ... */) }
       }
}

@Composable
fun SplashScreen(){

}
