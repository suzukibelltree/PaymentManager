package com.example.paymentmanager.data

import java.util.concurrent.Flow

class RecordsRepository(private val recordDao:RecordDao){
    suspend fun InsertRecord(record:Record){
        recordDao.InsertRecord(record)
    }

    suspend fun updateRecord(record: Record){
        recordDao.updateRecord(record)
    }

    suspend fun deleteRecord(record:Record){
        recordDao.deleteRecord(record)
    }

    suspend fun getRecord(id:Int):Record{
        return recordDao.getRecord(id)
    }

    suspend fun  getAllRecord():List<Record>{
        return recordDao.getAllRecords()
    }

}