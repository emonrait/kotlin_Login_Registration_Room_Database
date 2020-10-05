package com.example.kotlinloginregistrationroom.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "User_table", indices = arrayOf(
        Index(
            value = ["email", "mobile"],
            unique = true
        )
    )
)
data class User(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val email: String,
    val mobile: String,
    val address: String,
    val password: String,
)