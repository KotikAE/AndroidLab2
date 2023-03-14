package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.Adapter.RecyclerAdapter
import com.example.lab2.Util.UserDiffUtil
import com.example.lab2.ViewModel.AddUserVM
import com.example.lab2.ViewModel.ProjectVM
import com.example.lab2.databinding.ActivityMainBinding
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerAdapter
    private val addUserModel: AddUserVM by viewModels()
    private val fragment: FragmentAddUser = FragmentAddUser.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = ViewModelProvider(this)[ProjectVM::class.java]
        model.context = WeakReference(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        adapter = RecyclerAdapter()

        val itemTouchHelper = ItemTouchHelper(object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.layoutPosition
                    model.removeUsersFromDB(position)
                }
            })
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)



        model.getUsers().observe(this) {
            Log.d(TAG, "OBSERVE")
            val productDiffUtilCallback =
                UserDiffUtil(adapter.getUsers(), it)
            val productDiffResult =
                DiffUtil.calculateDiff(productDiffUtilCallback)
            adapter.setUsers(it)
            productDiffResult.dispatchUpdatesTo(adapter)
        }

        model.getUsersFromDB()

        binding.buttonAdd.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.placeHolder, fragment)
                .commit()
        }

        addUserModel.newUser.observe(this as LifecycleOwner, {
            model.addUsers(it)
            supportFragmentManager
                .beginTransaction()
                .remove(fragment)
                .commit()
        })

        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}