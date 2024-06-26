package com.example.simondicerec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.simondicerec.ui.UserInterface
import com.example.simondicerec.ui.theme.SimonDiceRECTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var myViewModel = MyViewModel()
        setContent {
            SimonDiceRECTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(255,100,150)
                ) {
                    UserInterface(miViewModel = myViewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    var myViewModel = MyViewModel()
    SimonDiceRECTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(255,100,150)
        ) {
            UserInterface(miViewModel = myViewModel)
        }
    }
}