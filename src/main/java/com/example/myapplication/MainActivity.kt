package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GuessNumberScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GuessNumberScreen(modifier: Modifier = Modifier) {
    val secretNumber = remember { Random.nextInt(0, 101) }

    var userInput by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("Введите число от 0 до 100") }
    var isGuessed by remember { mutableStateOf(false) }

    Column(modifier = modifier.padding(16.dp)) {

        if (isGuessed) {
            Image(
                painter = painterResource(id = android.R.drawable.btn_star_big_on),
                contentDescription = "Success image",
                modifier = Modifier.size(150.dp)
            )
        } else {
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = userInput,
            onValueChange = { newInput ->
                userInput = newInput
            },
            label = { Text("Введите число") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val number = userInput.toIntOrNull()

                if (number == null) {
                    message = "Введите корректное число"
                } else if (number < 0 || number > 100) {
                    message = "Число должно быть от 0 до 100"
                } else if (number < secretNumber) {
                    message = "Введенное число меньше загаданного"
                } else if (number > secretNumber) {
                    message = "Введенное число больше загаданного"
                } else {
                    isGuessed = true
                }
            }
        ) {
            Text("Проверить")
        }
    }
}
