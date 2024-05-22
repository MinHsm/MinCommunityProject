package com.example.mincommunityproject.ui.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.mincommunityproject.R
import com.example.mincommunityproject.databinding.ActivityPersonageBinding

class PersonageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_personage)
        binding.lifecycleOwner = this

        val window: Window = this@PersonageActivity.window
        window.statusBarColor = ContextCompat.getColor(this@PersonageActivity, R.color.blue)

        binding.apply {
            // 设置底部菜单选中项为主页
            menu.setItemSelected(R.id.profile)
            menu.setOnItemSelectedListener {
                if (it == R.id.Board) {
                    startActivity(Intent(this@PersonageActivity, CollectActivity::class.java))
                } else if (it == R.id.home) {
                    startActivity(Intent(this@PersonageActivity, MainActivity::class.java))
                }
            }
            // 设置按钮点击事件，跳转到问题活动页面并传递问题列表数据
        }
    }
}