package com.example.paymentmanager.ui.theme

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paymentmanager.data.Record
import com.example.paymentmanager.data.RecordDao
import kotlinx.coroutines.launch

class RecordScreenVM(private val recordDao:RecordDao) : ViewModel() {
    var ispayment by mutableStateOf(false) //収入か支出かを表す変数
    var amount by mutableStateOf("0") //金額を表す変数
    var description by mutableStateOf("") //備考欄の内容を表す変数


    fun createRecord(){
        val newRecord=Record(
            isPayment = ispayment ,
            amount = (amount).toInt(),
            description = description
        )
        viewModelScope.launch {
            recordDao.InsertRecord(newRecord)
        }
        Log.d("Test","room test success!")
    }
}