package com.example.mymoney

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Expense::class], version = 1)
abstract class DB : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDAO

    companion object {
        @Volatile
        private var INSTANCE: DB? = null
        fun getDB(context: Context): DB {
            if (INSTANCE == null)
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DB::class.java,
                        "expense"
                    ).build()
                }
            return INSTANCE!!
        }
    }
}