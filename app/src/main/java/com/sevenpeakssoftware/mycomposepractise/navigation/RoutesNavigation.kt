package com.sevenpeakssoftware.mycomposepractise.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sevenpeakssoftware.mycomposepractise.screens.detailsscreen.Detailscreen
import com.sevenpeakssoftware.mycomposepractise.screens.home.Homescreen

@Composable
fun RoutesNavigation(){

val navControll = rememberNavController()
    NavHost(navController = navControll,
        startDestination = RoutesInformation.Homescreen.name){
        composable(RoutesInformation.Homescreen.name){
          Homescreen(navController = navControll)
        }
        composable(RoutesInformation.Detailscreen.name+"/{pass1}",
            arguments= listOf(navArgument(name = "pass1"){
                type= NavType.StringType
            })){
           Detailscreen(navController = navControll,it)
        }
    }
}