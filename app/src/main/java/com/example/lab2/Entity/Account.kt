package com.example.lab2.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ACCOUNTS")
data class Account (
    @ColumnInfo(name = "login")
    var login: String,
    @ColumnInfo(name = "password")
    var password: String) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_account")
    var id: Int = 0
}