package com.example.lab2.DAO

import androidx.room.*
import com.example.lab2.Entity.User_Game

interface User_GameDao {
    @Insert
    fun insertUserGame(vararg userGame: User_Game)
    @Update
    fun updateUserGame(userGame: User_Game)
    @Delete
    fun deleteUserGame(userGame: User_Game)
}