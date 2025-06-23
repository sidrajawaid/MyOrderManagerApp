package com.example.myordermanager.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.myordermanager.R
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonNull.content


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    /*Surface {

        ModalNavigationDrawer(
            gesturesEnabled = true,
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Text("Drawer title", modifier = Modifier.padding(16.dp))
                    HorizontalDivider()
                    NavigationDrawerItem(
                        label = { Text(text = "Drawer Item1") },
                        selected = false,
                        onClick = {  *//* ToDo *//* })

                    // ...other drawer items
                }
            },
            modifier = TODO(),
            scrimColor = TODO(),
            content = TODO()
        )
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("My App") },
                    modifier = Modifier.padding(16.dp).background(Color.Gray),
                    actions = {
                        IconButton(onClick = { *//* Do something *//* }) {
                            Icon(Icons.Default.Search, contentDescription = "Search")
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            Log.d("<><>", " loggin g")
                            Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT).show()
                            scope.launch {
                                drawerState.open()

                            }
                        })
                        {
                            Icon(Icons.Default.Menu, contentDescription = "drawer")
                        }
                    }
                )
            },
        )
        {
            Column { Modifier.padding(it) }
        }

    }*/

    Surface(
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {

                        NavigationDrawerItem(
                            label = { Text(text = "Drawer Item1") },
                            selected = false,
                            onClick = {  /*TODO */})}}
            ,
            drawerState = drawerState
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Todo App")
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menu"
                                )
                            }
                        }
                    )
                }
            ) {
Column { Modifier.padding(it) }
            }
        }
    }
}
