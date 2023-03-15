package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.Adapter.RecyclerAdapter
import com.example.lab2.Util.UserDiffUtil
import com.example.lab2.ViewModel.ProjectVM
import com.example.lab2.databinding.ActivityMainBinding
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val model = ViewModelProvider(this)[ProjectVM::class.java]
        val fragment: FragmentAddUser = FragmentAddUser.newInstance()
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

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        model.getUsers().observe(this) {
            Log.d(TAG, "OBSERVE")
            val productDiffUtilCallback =
                UserDiffUtil(adapter.getUsers(), it)
            val productDiffResult =
                DiffUtil.calculateDiff(productDiffUtilCallback)
            adapter.setUsers(it)
            productDiffResult.dispatchUpdatesTo(adapter)
            model.getUsersFromDB()
            binding.recyclerView.adapter = adapter
        }



        fragment.getModel(model)

        binding.buttonAdd.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.placeHolder, fragment)
                .commit()
        }

        setContentView(binding.root)
    }
}