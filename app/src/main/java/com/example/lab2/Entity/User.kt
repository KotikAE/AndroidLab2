package com.example.lab2.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "USERS")
data class User(
    @ColumnInfo(name = "first_name")
    var firstName: String,
    @ColumnInfo(name = "last_name")
    var lastName: String) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_user")
    var id: Int = 0
}