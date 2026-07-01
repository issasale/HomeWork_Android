package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 5.2
        checkPassword("A")

        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
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
    MyApplicationTheme {
        Greeting("Android")
    }
}

// ======================
// 5.2
// ======================

fun checkPassword(password: String) {

    var score = 0

    if (password.length >= 8) score++

    if (password.any { it.isDigit() }) score++

    if (password.any { it.isUpperCase() }) score++

    if (password.any { it.isLowerCase() }) score++

    if (password.any { !it.isLetterOrDigit() }) score++

    when (score) {
        5 -> Log.d("PASSWORD", "Надежность пароля: надежный")
        4 -> Log.d("PASSWORD", "Надежность пароля: хороший")
        2, 3 -> Log.d("PASSWORD", "Надежность пароля: средняя")
        else -> Log.d("PASSWORD", "Надежность пароля: ненадежный")
    }
}