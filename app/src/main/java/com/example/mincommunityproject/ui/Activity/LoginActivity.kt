package com.example.mincommunityproject.ui.Activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.mincommunityproject.R
import com.example.mincommunityproject.databinding.ActivityLoginBinding
import com.example.mincommunityproject.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val window: Window = this@LoginActivity.window
        window.statusBarColor = ContextCompat.getColor(this@LoginActivity, R.color.blue)

        binding.apply {
            loginIconBack.setOnClickListener {
                onBackPressed()
            }
        }

    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("确定要退出吗？")
            .setPositiveButton("确定") { dialog, which ->
                super.onBackPressed()
            }
            .setNegativeButton("取消", null)
            .show()
    }

}