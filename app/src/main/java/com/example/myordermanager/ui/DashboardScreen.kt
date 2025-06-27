package com.example.myordermanager.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.myordermanager.R
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonNull.content


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {

    val navItemList = listOf(
        NavItems("Order List",
        ImageVector.vectorResource(R.drawable.order_list_selected),
            ImageVector.vectorResource(R.drawable.order_list_unselected),
            0),
        NavItems("Order Detail",
            ImageVector.vectorResource(R.drawable.order_list_selected),
            ImageVector.vectorResource(R.drawable.order_list_unselected),
            0),
        NavItems("Customer",
            ImageVector.vectorResource(R.drawable.order_list_selected),
            ImageVector.vectorResource(R.drawable.order_list_unselected),
            0),
        NavItems("Menu",
            ImageVector.vectorResource(R.drawable.order_list_selected),
            ImageVector.vectorResource(R.drawable.order_list_unselected),
            0),
    )


    Surface(
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }
        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
navItemList.forEachIndexed { index, navItems ->

    NavigationDrawerItem(
        label = { Text(text = navItems.title) },
        selected = index==selectedItemIndex,
        icon = {Icon(if (index == selectedItemIndex) {
            navItems.selectedIcon
        } else navItems.unselectedIcon,
            contentDescription = navItems.title)},
        onClick = {  selectedItemIndex = index
            scope.launch {
                drawerState.close()
            }},
        shape = RoundedCornerShape(10.dp)
    )
}
                        }}

            ,
            drawerState = drawerState,
            gesturesEnabled = true,
            scrimColor = Color.Red

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

data class NavItems(val title :String, val selectedIcon: ImageVector,
                    val unselectedIcon: ImageVector,
                    val badgeCount: Int? = null)
