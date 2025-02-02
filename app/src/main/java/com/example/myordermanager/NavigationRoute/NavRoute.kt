package com.example.myordermanager.NavigationRoute

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
object Profile
@Serializable
object Splash


@Composable
fun Route() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Profile) {
        composable<Profile> { ProfileScreen( /* ... */) }
        composable<Splash> { SplashScreen( /* ... */) }
        // Add more destinations similarly.
    }
}


@Composable
fun ProfileScreen(){

}
@Composable
fun SplashScreen(){

}