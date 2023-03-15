package com.example.lab2.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.lab2.DAO.UserDao
import com.example.lab2.Entity.User
import java.util.concurrent.Executors

@Database(entities = [User::class], version = 1)
abstract class ProjectDB: RoomDatabase() {
    abstract fun getUserDao(): UserDao

    companion object {
        @Volatile
        private lateinit var instance: ProjectDB

        fun getInstance(context: Context): ProjectDB {
            if (! ::instance.isInitialized)
                synchronized(ProjectDB::class.java) {
                    if(! ::instance.isInitialized) {
                        instance = Room
                            .databaseBuilder(context, ProjectDB::class.java, "project_db")
                            .addCallback(object : Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
//                                    val user = User("Ivan", "Ivanov")
//                                    val user2 = User("Petr", "Petrov")
//                                    Executors.newSingleThreadExecutor().execute { instance.getUserDao().insertUser(user, user2) }
                                }
                            } )
                            .build()
                    }
                }
            return instance
        }
    }
}