package com.example.paymentmanager

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.paymentmanager.ui.theme.HistoryScreenUI
import com.example.paymentmanager.ui.theme.HomeScreenUI
import com.example.paymentmanager.ui.theme.PaymentManagerTheme
import com.example.paymentmanager.ui.theme.RecordScreenUI
import com.example.paymentmanager.ui.theme.RecordScreenVM
import com.example.paymentmanager.ui.theme.SettingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("lifecycle","onCreate called")
        super.onCreate(savedInstanceState)
        setContent {
            PaymentManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val recordViewModel: RecordScreenVM by viewModels()
                    PaymentManageApp(recordViewModel=recordViewModel)
                }
            }
        }
    }
}




