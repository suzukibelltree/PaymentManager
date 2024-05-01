package com.example.paymentmanager.ui.theme

import android.provider.MediaStore.Audio.Radio
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@Composable
fun RecordScreenUI(
){
    val radiooptions= listOf("収入","支出")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radiooptions[1] ) }
    var value by remember { mutableStateOf("") }
    var memo by remember { mutableStateOf("") }
    Column(
        modifier=Modifier.padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        radiooptions.forEach { text->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) }
                    )
            ) {
                RadioButton(selected = (text==selectedOption), onClick = { onOptionSelected(text) })
                Text(text = text, fontSize = 22.sp)
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier=Modifier.align(Alignment.Start)) {
            Text(text = "金額", fontSize = 28.sp)
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(value = value,
                onValueChange = {value=it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
        }
        Spacer(modifier =Modifier.height(24.dp))
        Row(modifier=Modifier.align(Alignment.Start)) {
            Text(text = "備考欄", fontSize = 28.sp)
        }
        OutlinedTextField(value =memo ,
            onValueChange ={memo=it}
        )
        Button(onClick = { /*TODO*/ },) {
            Text(text = "記録する")
        }
    }
}