package com.sevenpeakssoftware.mycomposepractise.screens.detailsscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
fun Detailscreen(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.LightGray,
        elevation = 5.dp) {
            
            Row {
                 Icon(tint = Color.White,modifier = Modifier.clickable {
                     navController.popBackStack()
                 },imageVector = Icons.Default.ArrowBack, contentDescription ="Details Screen" )
                
                Spacer(modifier = Modifier
                    .width(48.dp)
                    .clickable {
                        navController.popBackStack()
                    })
                Text(text = "Details Page", style = TextStyle(fontSize = 23.sp))
            }
        }
    }) {

        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            elevation = 7.dp) {
            Column(horizontalAlignment= Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(style = MaterialTheme.typography.h4,text = "Details Screen :"+navBackStackEntry.arguments?.getString("pass1"))
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    navController.popBackStack()
                }) {
                    Text(text = "Go Back")
                }
            }

        }
    }

    
}