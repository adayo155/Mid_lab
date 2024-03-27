package com.example.mid_lab

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mid_lab.ui.theme.Mid_labTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mid_labTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    lunchingeffect(modifier = Modifier )
                    //CitySelection(modifier = Modifier)
                    Mid_lab()
                }
            }
        }
    }
}

@Composable
fun Mid_lab(){
    val navController = rememberNavController()


    NavHost(navController = navController,
        startDestination = "Sky_Sight"){
        composable("Sky_Sight"){
            CitySelection(navController = navController) }
        composable("check"){
            WeatherDetails(navController = navController) }
    }


}




@Composable
fun <NavHostController> WeatherDetails (modifier: Modifier = Modifier,
                                        context: Context = LocalContext.current,
                                        navController : NavHostController){
    Text(text = "Weather Details", textAlign = TextAlign.Left)

    Column(
        modifier= Modifier
            .padding(5.dp)
            .height(70.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "City Name : Karachi ")

        Row (modifier = Modifier ){
            Image(painter = painterResource(id = R.drawable.baseline_device_thermostat_24),
                contentDescription ="",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(10.dp))



            Column(
                modifier= Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .height(70.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Text(text = "Temperature",
                    textAlign = TextAlign.Left,
                    modifier= Modifier
                        .width(300.dp)
                        .padding(5.dp)
                        .offset(0.dp, 4.dp))

                Text(text = "32c",
                    textAlign = TextAlign.Left,
                    modifier= Modifier
                        .width(300.dp)
                        .padding(5.dp)
                        .offset(2.dp, 2.dp))
            }

        }


        }


    }

@Composable
fun CitySelection(modifier: Modifier = Modifier,
                  context: Context = LocalContext.current,
                  navController : NavHostController
){
    var text by remember { mutableStateOf("") }

    Text(text = "Sky Sight", textAlign = TextAlign.Left)


    Column(
        modifier= Modifier
            .padding(5.dp)
            .height(70.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {



        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription ="",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(10.dp))

        Image(painter = painterResource(id = R.drawable.map),
            contentDescription ="",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(500.dp)
                .height(300.dp)
                .padding(10.dp))

        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            label = { Text("Enter City Name ") }, // Optional label
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done // Optional keyboard action
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    // Define action to be taken when the user presses Done on the keyboard
                }
            )
        )

        Button(onClick = {navController.navigate("check")}) {
            Text(text = "Show Weather")
            
        }
    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun lunchingeffect(modifier: Modifier = Modifier,
                   context: Context = LocalContext.current,
                   navController : NavHostController
){
    Column(
        modifier= Modifier
            .padding(5.dp)
            .height(70.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription ="",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(10.dp))

        TextButton(onClick  = {
            navController.navigate("Sky_Sight")
        }) {
            Text(text = "Sky Sight")

        }

    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mid_labTheme {
//        lunchingeffect(modifier = Modifier)
      //  CitySelection(modifier = Modifier)
    }
}



