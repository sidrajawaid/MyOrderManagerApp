package com.example.myordermanager.activities


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myordermanager.NavigationRoute.Route
import com.example.myordermanager.ui.theme.AppTheme


class DashboardActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent(){
          AppTheme {
              Route()
          }

        }

    }


}