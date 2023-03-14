package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.lab2.Entity.User
import com.example.lab2.ViewModel.AddUserVM
import com.example.lab2.databinding.FragmentAddUserBinding

class FragmentAddUser : Fragment() {
    lateinit var binding: FragmentAddUserBinding
    private val addUserModel: AddUserVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddUserBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonApply.setOnClickListener {
            addUserModel.newUser.value = User(binding.newUserFName.text.toString(), binding.newUserLName.text.toString())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentAddUser()
    }
}