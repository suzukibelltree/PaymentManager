package com.example.paymentmanager.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "Records")
data class Record @Ignore constructor(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,//記録のid
    var isPayment:Boolean=true,//支払いか否か
    var amount:Int=0,//金額
    var description:String=""//備考欄の記述
){
    constructor():this(0,true,0,"")
}
