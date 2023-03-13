package com.example.lab2.DAO

import androidx.room.*
import com.example.lab2.Entity.Account

@Dao
interface AccountDao {
    @Insert
    fun insertAccount(vararg account: Account)
    @Update
    fun updateAccount(account: Account)
    @Delete
    fun deleteAccount(account: Account)
    @Query("SELECT * FROM ACCOUNTS")
    fun getAll(): MutableList<Account>
    @Query("SELECT * FROM ACCOUNTS WHERE login = :login")
    fun getAllByLogin(login: String): MutableList<Account>
}