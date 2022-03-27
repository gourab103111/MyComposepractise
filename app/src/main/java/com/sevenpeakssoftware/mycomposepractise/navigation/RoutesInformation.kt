package com.sevenpeakssoftware.mycomposepractise.navigation

import java.lang.IllegalArgumentException

enum class RoutesInformation {
    Homescreen,
    Detailscreen;
    companion object {
        fun fromRoute(routes:String?) :RoutesInformation
        = when (routes?.substringBefore("/")){
            Homescreen.name -> Homescreen
            Detailscreen.name -> Detailscreen
            null->Homescreen
            else -> throw  IllegalArgumentException("Route $routes is not recognize")

        }
    }
}