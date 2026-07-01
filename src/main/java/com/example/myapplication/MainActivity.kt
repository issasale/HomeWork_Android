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

        //5.1
        analyzeIntList(listOf(67, -14, 22, -8, 15))


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
// 5.1
// ======================

fun analyzeIntList(input: List<Int>) {

    val min = input.minOrNull()
    val max = input.maxOrNull()
    val sum = input.sum()

    val evenCount = input.count { it % 2 == 0 }
    val oddCount = input.count { it % 2 != 0 }

    Log.d("HOMEWORK", "Минимальное: $min")
    Log.d("HOMEWORK", "Максимальное: $max")
    Log.d("HOMEWORK", "Сумма: $sum")
    Log.d("HOMEWORK", "Четных: $evenCount")
    Log.d("HOMEWORK", "Нечетных: $oddCount")
}

