package com.example.lab2.DAO

import androidx.room.*
import com.example.lab2.Entity.Game

interface GameDao {
    @Insert
    fun insertGame(vararg game: Game)
    @Update
    fun updateGame(game: Game)
    @Delete
    fun deleteGame(game: Game)
    @Query("SELECT * FROM GAMES")
    fun getAll(): MutableList<Game>
    @Query("SELECT * FROM GAMES WHERE title = :title")
    fun getAllByTitle(title: String): MutableList<Game>
    @Query("SELECT * FROM GAMES WHERE cost = :cost")
    fun getAllByCost(cost: Double): MutableList<Game>
}