package com.example.mincommunityproject.ui.Activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.mincommunityproject.R
import com.example.mincommunityproject.databinding.ActivityLoginBinding
import com.example.mincommunityproject.model.LoginResponse
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

        viewModel.loginResult.observe(this, Observer { result ->
            result.onSuccess { loginResponse ->
                //成功获取token和用户信息
                val token = loginResponse.data.token
                val customer = loginResponse.data.customer

                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
            }.onFailure { throwable ->
                Toast.makeText(this, "登录失败:${throwable.message}", Toast.LENGTH_SHORT).show()
                Log.d("LoginMsg","错误信息:${throwable.message}")
            }
        })

        binding.loginBtnLogin.setOnClickListener {
            val email = binding.loginEtUn.toString()
            val pwd = binding.loginEtPwd.toString()
            viewModel.login(email, pwd)
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