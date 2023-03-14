package com.example.lab2.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab2.Entity.User

open class AddUserVM: ViewModel() {
    val newUser: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }
}