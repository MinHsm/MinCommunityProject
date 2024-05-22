package com.example.mincommunityproject.ui.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mincommunityproject.R
import com.example.mincommunityproject.databinding.ActivityMainBinding
import com.example.mincommunityproject.model.MainItem
import com.example.mincommunityproject.ui.Adapter.MainItemAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemAdapter: MainItemAdapter
    private lateinit var itemList: List<MainItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        val window: Window = this@MainActivity.window
        window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.blue)

        binding.apply {
            // 设置底部菜单选中项为主页
            menu.setItemSelected(R.id.home)
            menu.setOnItemSelectedListener {
                if (it == R.id.Board) {
                    startActivity(Intent(this@MainActivity, CollectActivity::class.java))
                } else if (it == R.id.profile) {
                    startActivity(Intent(this@MainActivity, PersonageActivity::class.java))
                }
            }
            // 设置按钮点击事件，跳转到问题活动页面并传递问题列表数据
        }

        binding.tvMainAttention.setOnClickListener {
            binding.tvMainAttention.setTextColor(Color.BLACK)
            binding.tvMainAttention.setTextSize(20F)

            binding.tvMainRecommend.setTextSize(16F)
            binding.tvMainRecommend.setTextColor(Color.GRAY)

            binding.tvMainLive.setTextSize(16F)
            binding.tvMainLive.setTextColor(Color.GRAY)

            binding.tvMainStudy.setTextSize(16F)
            binding.tvMainStudy.setTextColor(Color.GRAY)

            binding.tvMainQuestion.setTextSize(16F)
            binding.tvMainQuestion.setTextColor(Color.GRAY)
        }

        binding.tvMainQuestion.setOnClickListener {
            binding.tvMainQuestion.setTextColor(Color.BLACK)
            binding.tvMainQuestion.setTextSize(20F)

            binding.tvMainRecommend.setTextSize(16F)
            binding.tvMainRecommend.setTextColor(Color.GRAY)

            binding.tvMainLive.setTextSize(16F)
            binding.tvMainLive.setTextColor(Color.GRAY)

            binding.tvMainStudy.setTextSize(16F)
            binding.tvMainStudy.setTextColor(Color.GRAY)

            binding.tvMainAttention.setTextSize(16F)
            binding.tvMainAttention.setTextColor(Color.GRAY)
        }

        binding.tvMainLive.setOnClickListener {
            binding.tvMainLive.setTextColor(Color.BLACK)
            binding.tvMainLive.setTextSize(20F)

            binding.tvMainRecommend.setTextSize(16F)
            binding.tvMainRecommend.setTextColor(Color.GRAY)

            binding.tvMainQuestion.setTextSize(16F)
            binding.tvMainQuestion.setTextColor(Color.GRAY)

            binding.tvMainStudy.setTextSize(16F)
            binding.tvMainStudy.setTextColor(Color.GRAY)

            binding.tvMainAttention.setTextSize(16F)
            binding.tvMainAttention.setTextColor(Color.GRAY)
        }

        binding.tvMainStudy.setOnClickListener {
            binding.tvMainStudy.setTextColor(Color.BLACK)
            binding.tvMainStudy.setTextSize(20F)

            binding.tvMainRecommend.setTextSize(16F)
            binding.tvMainRecommend.setTextColor(Color.GRAY)

            binding.tvMainLive.setTextSize(16F)
            binding.tvMainLive.setTextColor(Color.GRAY)

            binding.tvMainLive.setTextSize(16F)
            binding.tvMainLive.setTextColor(Color.GRAY)

            binding.tvMainAttention.setTextSize(16F)
            binding.tvMainAttention.setTextColor(Color.GRAY)
        }

        binding.tvMainRecommend.setOnClickListener {
            binding.tvMainRecommend.setTextColor(Color.BLACK)
            binding.tvMainRecommend.setTextSize(20F)

            binding.tvMainQuestion.setTextSize(16F)
            binding.tvMainQuestion.setTextColor(Color.GRAY)

            binding.tvMainLive.setTextSize(16F)
            binding.tvMainLive.setTextColor(Color.GRAY)

            binding.tvMainStudy.setTextSize(16F)
            binding.tvMainStudy.setTextColor(Color.GRAY)

            binding.tvMainAttention.setTextSize(16F)
            binding.tvMainAttention.setTextColor(Color.GRAY)
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