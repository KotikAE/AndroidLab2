package com.example.lab2.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.Entity.User
import com.example.lab2.databinding.ItemBinding

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var users: MutableList<User> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setUsers(users: MutableList<User>) {
        this.users = users
    }

    fun getUsers(): MutableList<User> {
        return users
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = users[position]
        //holder.binding.idField.text = item.id.toString()
        holder.binding.firstNameField.text = item.firstName
        holder.binding.lastNameField.text = item.lastName
    }

    override fun getItemCount(): Int = users.size

    inner class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        override fun toString(): String {
            itemView
            return super.toString() + " '" + binding.firstNameField.text + "'"
        }
    }
}