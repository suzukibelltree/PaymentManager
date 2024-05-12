package com.example.paymentmanager.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface RecordDao {
    @Insert
    fun InsertRecord(record:Record)

    @Update
    suspend fun updateRecord(record:Record)

    @Delete
    suspend fun deleteRecord(record:Record)

    @Query("SELECT * from Records WHERE id = :id")
    fun getRecord(id: Int):Record

    @Query("SELECT * FROM Records")
    fun getAllRecords():List<Record>
}