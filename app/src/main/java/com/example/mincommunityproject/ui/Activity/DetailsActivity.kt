package com.example.mincommunityproject.ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.mincommunityproject.R
import com.example.mincommunityproject.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        binding.lifecycleOwner = this

        //设置顶部颜色
        val window: Window = this@DetailsActivity.window
        window.statusBarColor = ContextCompat.getColor(this@DetailsActivity, R.color.blue)

        binding.apply {
            detTopBack.setOnClickListener {
                onBackPressed()
            }
        }
        // 获取传递的数据
        val itemId = intent.getIntExtra("TIME_ID", -1)
        // 根据itemId加载相关数据
        if (itemId != -1) {
            // 在这里处理你的数据，例如从数据库加载详细信息并显示
        }
    }
}