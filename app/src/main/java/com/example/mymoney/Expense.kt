package com.example.mymoney

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "expense")
data class Expense(
    @PrimaryKey
    val id : UUID,
    val title : String,
    val amount : Int
)
