package com.example.lab2.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "USER_GAMES", foreignKeys = [
    ForeignKey(entity = User::class,
        parentColumns = arrayOf("id_user"),
        childColumns = arrayOf("user_id"),
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE),
    ForeignKey(entity = Game::class,
        parentColumns = arrayOf("id_game"),
        childColumns = arrayOf("game_id"),
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE)])
data class User_Game (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_user_game")
    var id: Int = 0,
    @ColumnInfo(name = "user_id")
    var user_id: String,
    @ColumnInfo(name = "game_id")
    var game_id: String
)