package com.example.numberguessinggame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.numberguessinggame.ui.theme.NumberGuessingGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NumberGuessingGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    User("Android")
                }
            }
        }
    }
}

@Composable
fun User(name: String, modifier: Modifier = Modifier) {
    val (person, setNumberInput) = remember { mutableStateOf("") }


    Column (
         modifier = Modifier
             .fillMaxSize()
             .background(Color.LightGray)
             .padding(
                 top = 10.dp,
                 bottom = 10.dp,
                 start = 5.dp
             ),
     ){

         Text(
               text = "Number Guessing Game",
               modifier = Modifier.padding(bottom = 10.dp)
           )
         Text(
             text = "You have three choices, Enter three numbers",
             modifier = Modifier.padding(bottom = 10.dp)
         )
         Text(
             text = "Enter first number",
             modifier = Modifier.padding(bottom = 50.dp)
         )
        TextField(
            value =person,
            onValueChange = { setNumberInput(it) },
            label = { Text("Enter a number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
    }
    val num =(1..10).random()
         if (person==num.toString()){
             Text(
                 text ="Your guess is correct!"
             )
             println(num)
             return
         }
         else if (person> num.toString()){
             Text(
                 text = "Your guess is too high"
             )
         }
         else if (person<num.toString()){
             Text(
                 text = "Your guess is too low"
             )
         }
         else{
             Text(
                 text = "Enter second number"
             )
         }
     }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NumberGuessingGameTheme {
        User("Android")
    }
}