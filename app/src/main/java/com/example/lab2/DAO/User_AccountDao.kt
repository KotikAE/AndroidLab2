package com.example.lab2.DAO

import androidx.room.*
import com.example.lab2.Entity.User_Account

interface User_AccountDao {
    @Insert
    fun insertUserAccount(vararg userAccount: User_Account)
    @Update
    fun updateUserAccount(userAccount: User_Account)
    @Delete
    fun deleteUserAccount(userAccount: User_Account)
}