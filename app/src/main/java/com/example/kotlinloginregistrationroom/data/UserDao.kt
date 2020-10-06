package com.example.kotlinloginregistrationroom.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Query("SELECT * FROM user_table WHERE email=(:email) and password=(:password)")
    fun userLogin(email: String, password: String): User

    @Update
    suspend fun updateUser(user: User)

}
