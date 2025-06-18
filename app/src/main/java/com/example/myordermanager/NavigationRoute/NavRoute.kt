package com.example.myordermanager.NavigationRoute

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myordermanager.ViewModel.AuthenticationViewmodel
import com.example.myordermanager.ui.DashboardScreen
import com.example.myordermanager.ui.LoginScreen
import kotlinx.serialization.Serializable



@Serializable
object Dashboard

@Serializable
object Login


@Serializable
object Splash


@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun Route() {

    val navController = rememberNavController()
  //  val viewmodel : AuthenticationViewmodel = viewModel()
   // val viewmodel = hiltvi<AuthenticationViewmodel>()
    NavHost(navController = navController, startDestination = Dashboard) {
        composable<Dashboard> { DashboardScreen()
        }
        composable<Login> { LoginScreen("",hiltViewModel<AuthenticationViewmodel>())
        }
        composable<Splash> { SplashScreen( /* ... */) }
       }
}

@Composable
fun SplashScreen(){

}
