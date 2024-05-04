@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.paymentmanager.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.core.component.text.TextComponent
import com.patrykandpatrick.vico.core.entry.entryModelOf
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun HomeScreenUI(
    onAddButtonClicked:()->Unit
){
    Column(modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Showpayments()
        ShowGraph()
        Spacer(modifier = Modifier.height(18.dp))
        Button(onClick = { onAddButtonClicked() },) {
            Text(text = "収支を記録")
        }
    }
}


@Composable
fun Showpayments(
    modifier:Modifier=Modifier
){
Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Spacer(modifier = Modifier.height(12.dp))
    Row(modifier=Modifier.fillMaxWidth()) {
        Text(text = "今日の収支",
            fontSize = 24.sp,
            fontWeight= FontWeight.Bold,
            modifier = Modifier.padding(12.dp))
        Text(text = "-1500円",
            fontSize = 26.sp,
            fontWeight= FontWeight.Bold,
            modifier=modifier.padding(12.dp))
    }
    Row(modifier=Modifier.fillMaxWidth()) {
        Text(text = "今月の収支",
            fontSize = 24.sp,
            fontWeight= FontWeight.Bold,
            modifier = Modifier.padding(12.dp))
        Text(text = "+12000円",
            fontSize = 26.sp,
            fontWeight= FontWeight.Bold,
            modifier=modifier.padding(12.dp))
    }
}
}

@Composable
fun ShowGraph(){
    //ここはあとで修正
    val chartEntryModel = entryModelOf(5f, 3f, 4f, 2f, 1f)
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Chart(
            chart = lineChart(),
            model = chartEntryModel,
            startAxis = rememberStartAxis(),
            bottomAxis = rememberBottomAxis(
                title = "日付",
                titleComponent = TextComponent.Builder().build(),
                valueFormatter = { value, _ ->
                    val date = LocalDate.now().plusDays(value.toLong())
                    DateTimeFormatter.ofPattern("MM月dd日").format(date)
                }
            ),
        )
    }
}


