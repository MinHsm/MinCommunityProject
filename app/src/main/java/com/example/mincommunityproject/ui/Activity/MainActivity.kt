package com.example.mincommunityproject.ui.Activity

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mincommunityproject.R
import com.example.mincommunityproject.databinding.ActivityMainBinding
import com.example.mincommunityproject.model.MainItem
import com.example.mincommunityproject.ui.Adapter.MainItemAdapter
import com.example.mincommunityproject.viewmodel.MainTitleViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemAdapter: MainItemAdapter
    private lateinit var itemList: List<MainItem>
    private lateinit var viewModel: MainTitleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainTitleViewModel::class.java)
        binding.lifecycleOwner = this

        val window: Window = this@MainActivity.window
        window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.blue)

        binding.apply {
            // 设置底部菜单选中项为主页
            menu.setItemSelected(R.id.home)

            // 设置按钮点击事件，跳转到问题活动页面并传递问题列表数据
        }

        getItemData()
    }

    private fun getItemData() {
        itemList = listOf(
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏"),
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏"),
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏"),
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏"),
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏"),
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏"),
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏"),
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏")
        )

        Log.d("MainActivity", "Item list size:${itemList.size}")

        itemAdapter = MainItemAdapter(this@MainActivity, itemList)

        binding.lvMainItem.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = itemAdapter
        }
    }
}