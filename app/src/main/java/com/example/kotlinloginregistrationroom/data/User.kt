package com.example.kotlinloginregistrationroom.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
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

) : Parcelable

