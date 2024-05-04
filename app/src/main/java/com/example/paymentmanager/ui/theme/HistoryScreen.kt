package com.example.paymentmanager.ui.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun HistoryScreenUI(){
    Text(text = "記録履歴画面", fontSize = 20.sp)
    ShowRecordingList()
}

@Composable
fun ShowRecordingList(){
    //roomからデータを持ってきて記録日時が新しい10件?を表示する
}