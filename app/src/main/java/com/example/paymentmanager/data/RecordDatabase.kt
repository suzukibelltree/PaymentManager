package com.example.paymentmanager.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Record::class],version=1)
abstract class RecordDatabase:RoomDatabase() {
    abstract fun recordDao(): RecordDao

    companion object {
        @Volatile
        private var Instance: RecordDatabase? = null

        fun getDatabase(context: Context): RecordDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, RecordDatabase::class.java, "record_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
