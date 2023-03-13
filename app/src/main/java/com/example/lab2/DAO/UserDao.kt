package com.example.lab2.DAO

import androidx.room.*
import com.example.lab2.Entity.User

interface UserDao {
    @Insert
    fun insertUser(vararg user: User)
    @Update
    fun updateUser(user: User)
    @Delete
    fun deleteUser(user: User)
    @Query("SELECT * FROM USERS")
    fun getAll(): MutableList<User>
    @Query("SELECT * FROM USERS WHERE first_name = :firstName")
    fun getAllByFirstName(firstName: String): MutableList<User>
    @Query("SELECT * FROM USERS WHERE last_name = :lastName")
    fun getAllByLastName(lastName: String): MutableList<User>
}