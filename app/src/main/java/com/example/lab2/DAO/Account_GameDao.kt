package com.example.lab2.DAO

import androidx.room.*
import com.example.lab2.Entity.Account_Game

@Dao
interface Account_GameDao {
    @Insert
    fun insertAccountGame(vararg accountGame: Account_Game)
    @Update
    fun updateAccountGame(accountGame: Account_Game)
    @Delete
    fun deleteAccountGame(accountGame: Account_Game)
}