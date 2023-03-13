package com.example.lab2.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "USER_ACCOUNTS", foreignKeys = [
    ForeignKey(entity = User::class,
        parentColumns = arrayOf("id_user"),
        childColumns = arrayOf("user_id"),
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE),
    ForeignKey(entity = Account::class,
        parentColumns = arrayOf("id_account"),
        childColumns = arrayOf("account_id"),
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE)])
data class User_Account (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_user_account")
    var id: Int = 0,
    @ColumnInfo(name = "user_id")
    var user_id: String,
    @ColumnInfo(name = "account_id")
    var account_id: String
)