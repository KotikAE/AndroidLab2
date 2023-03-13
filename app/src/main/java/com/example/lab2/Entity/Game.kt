package com.example.lab2.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GAMES")
data class Game (
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "cost")
    var cost: Double) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_game")
    var id: Int = 0
}