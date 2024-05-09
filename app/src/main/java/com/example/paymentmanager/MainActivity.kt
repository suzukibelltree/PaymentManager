package com.example.paymentmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
<<<<<<< HEAD
import androidx.activity.enableEdgeToEdge
=======
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxHeight
>>>>>>> 8efbb2f (記録画面においてViewModelを導入)
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.paymentmanager.ui.theme.PaymentManagerTheme
<<<<<<< HEAD
=======
import com.example.paymentmanager.ui.theme.RecordScreenUI
import com.example.paymentmanager.ui.theme.RecordScreenVM
import com.example.paymentmanager.ui.theme.SettingScreen
>>>>>>> 8efbb2f (記録画面においてViewModelを導入)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PaymentManagerTheme {
<<<<<<< HEAD
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                    )
=======
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val recordViewModel: RecordScreenVM by viewModels()
                    PaymentManageApp(recordViewModel=recordViewModel)
>>>>>>> 8efbb2f (記録画面においてViewModelを導入)
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
    PaymentManagerTheme {
        Greeting("Android")
    }
}