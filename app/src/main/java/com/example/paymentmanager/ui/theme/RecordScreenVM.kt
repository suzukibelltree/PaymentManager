package com.example.paymentmanager.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RecordScreenVM: ViewModel() {
    var ispayment by mutableStateOf(false)
    var amount by mutableStateOf("0")
    var description by mutableStateOf("")
}