package com.example.paymentmanager

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.paymentmanager.ui.theme.HistoryScreenUI
import com.example.paymentmanager.ui.theme.HomeScreenUI
import com.example.paymentmanager.ui.theme.RecordScreenUI
import com.example.paymentmanager.ui.theme.RecordScreenVM
import com.example.paymentmanager.ui.theme.SettingScreen

enum class AppScreen (){
    Home,
    History,
    Setting,
    Record
}

@Composable
fun PaymentManageApp(
    navController:NavHostController= rememberNavController(),
    recordViewModel:RecordScreenVM
){
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.LightGray,
                actions = {
                    Spacer(modifier = Modifier.weight(1f))
                    Column {
                        IconButton(onClick = { navController.navigate(AppScreen.Home.name) }) {
                            Icon(Icons.Filled.Home, contentDescription = "Localized description")
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column {
                        IconButton(onClick = { navController.navigate(AppScreen.History.name) }) {
                            Icon(
                                Icons.Filled.Menu,
                                contentDescription = "Localized description",
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column {
                        IconButton(onClick = { navController.navigate(AppScreen.Setting.name) }) {
                            Icon(
                                Icons.Filled.Settings,
                                contentDescription = "Localized description",
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                },
            )
        }
    ) {
        innerpadding ->Unit
        NavHost(navController =navController ,
            startDestination =AppScreen.Home.name ) {
            composable(route=AppScreen.Home.name) {
                HomeScreenUI(onAddButtonClicked={navController.navigate(AppScreen.Record.name)})
            }
            composable(route=AppScreen.History.name){
                HistoryScreenUI()
            }
            composable(route=AppScreen.Setting.name){
                SettingScreen()
            }
            composable(route=AppScreen.Record.name){
                RecordScreenUI(
                    onRecordButtonClicked = {navController.navigate(AppScreen.Home.name)},
                    recordVM = recordViewModel
                    )
            }
        }
    }
}