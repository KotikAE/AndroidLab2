package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab2.Entity.User
import com.example.lab2.ViewModel.ProjectVM
import com.example.lab2.databinding.FragmentAddUserBinding
class FragmentAddUser() : Fragment() {
    lateinit var binding: FragmentAddUserBinding
    lateinit var activityModel: ProjectVM

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
            var newUser = User(binding.newUserFName.text.toString(), binding.newUserLName.text.toString())
            activityModel.addUsers(newUser)
            getActivity()?.getSupportFragmentManager()?.beginTransaction()?.remove(this)?.commit()
        }
    }

    fun getModel(model: ProjectVM) {
        activityModel = model
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentAddUser()
    }
}