package com.example.lab2.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "ACCOUNT_GAMES", foreignKeys = [
    ForeignKey(entity = Account::class,
        parentColumns = arrayOf("id_account"),
        childColumns = arrayOf("account_id"),
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE),
    ForeignKey(entity = Game::class,
        parentColumns = arrayOf("id_game"),
        childColumns = arrayOf("game_id"),
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE)])
data class Account_Game (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_account_game")
    var id: Int = 0,
    @ColumnInfo(name = "account_id")
    var account_id: String,
    @ColumnInfo(name = "game_id")
    var game_id: String
)