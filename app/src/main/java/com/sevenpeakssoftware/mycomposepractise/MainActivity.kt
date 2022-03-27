package com.sevenpeakssoftware.mycomposepractise

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sevenpeakssoftware.mycomposepractise.navigation.RoutesNavigation
import com.sevenpeakssoftware.mycomposepractise.ui.theme.MyComposepractiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            RoutesNavigation()

        }
    }
}


@Composable
fun MyAppContent(content: @Composable ()-> Unit) {
    MyComposepractiseTheme {
        Scaffold(topBar = {
            TopAppBar(backgroundColor = Color.Magenta, elevation =  10.dp) {
                
                Text(text = "Home Panel")
                
            }
        }) {
            content()
        }
        
      //  

    }

}

@Composable
fun MainContent(itemLists:List<String> = listOf(
    "List  1",
    "Lists 2",
    "Lists 3",

)){
    Surface( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(all = 5.dp),
    color = MaterialTheme.colors.background,) {
          Column(modifier = Modifier.padding(12.dp)) {
              LazyColumn{
                  items(items = itemLists){
                      rowBox(detailsText = it){

                          Log.d("Tag","ItemName : $it")
                      }
                     // Text(text = "")

                  }
              }
          }
    }

}


@Composable
fun rowBox(detailsText:String, onClickCliable:(String) -> Unit={}){

    Card(
        elevation= 6.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clickable {
                onClickCliable(detailsText)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp),)
    ) {
        Row(verticalAlignment= Alignment.CenterVertically,
            horizontalArrangement= Arrangement.Start) {

            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
            shape = RectangleShape,
            elevation = 4.dp) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Profile Image")

            }
            Text(text = detailsText)
        }


    }
}

@Composable
fun Main() {
    //Text(text = "Hello $name!")
    MyAppContent {
        MainContent()
    }

    /*
    MyComposepractiseTheme {

        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(all = 34.dp),
            color = MaterialTheme.colors.background, ) {

            Greeting("Android")
        }

        */

}

@Composable
fun Greeting(name: String) {
    var counterincrease = remember { mutableStateOf(0)
    }
    Column(modifier = Modifier
        .background(Color.Gray)
        .fillMaxWidth(fraction = 60.0f)
        .padding(20.dp)) {

        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

            Card(shape = CircleShape, modifier = Modifier
                .padding(4.dp)
                .width(120.dp)
                .height(120.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                    Text(text = "Cercle ${counterincrease.value}", style = TextStyle(
                        fontSize = 18.sp
                    ))

                }

            }
            
            Button(modifier = Modifier.padding(start = 0.dp, top = 10.dp, end = 0.dp, bottom = 0.dp),onClick = {

                counterincrease.value +=1

            }, ) {
                Text(text = "Click Me")

            }

        }

        Text(text = "Hello $name!",Modifier.padding(start = 0.dp, top = 20.dp, end = 0.dp, bottom = 0.dp))
        Text(text = "Age 34")

    }

}

@Preview(showBackground= true, name = "Me")
@Composable
fun DefaultPreview() {
    Main()
}