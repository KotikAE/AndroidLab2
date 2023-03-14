package com.example.lab2.ViewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab2.Database.ProjectDB
import com.example.lab2.Entity.User
import java.lang.ref.WeakReference
import java.util.concurrent.Executors

class ProjectVM: ViewModel() {
    lateinit var context: WeakReference<Context>
    private val users = MutableLiveData<MutableList<User>>()

    init {
        users.value = mutableListOf()
    }
    private val executor = Executors.newSingleThreadExecutor()

    fun getUsers(): MutableLiveData<MutableList<User>> {
        return users
    }

    fun addUsers(user: User) {
        context.get()?.let {
            executor.submit {
                ProjectDB.getInstance(it).getUserDao().insertUser(user)
                users.value?.add(user)
                users.postValue(users.value)
            }
        }
    }

    fun getUsersFromDB() {
        context.get()?.let {
            executor.submit {
                users.value?.addAll(ProjectDB.getInstance(it).getUserDao().getAll())
                users.postValue(users.value)
            }
        }
    }

    fun removeUsersFromDB(position: Int) {
        context.get()?.let {ctx->
            Executors.newSingleThreadExecutor().execute {
                users.value?.let {
                    ProjectDB.getInstance(ctx).getUserDao().deleteUser((it[position]))
                    users.value?.removeAt(position)
                    users.postValue(users.value)
                }
            }

        }
    }
}