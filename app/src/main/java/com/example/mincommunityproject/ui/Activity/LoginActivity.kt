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
/**
 * 登录页面
 * @author Min
 * @time 2024/6/2 20:17
 */
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        //设置顶部颜色
        val window: Window = this@LoginActivity.window
        window.statusBarColor = ContextCompat.getColor(this@LoginActivity, R.color.blue)

        //监听返回按钮，点击调用返回方法
        binding.apply {
            loginIconBack.setOnClickListener {
                onBackPressed()
            }
        }

        //监听viewmodel里的方法
        viewModel.loginResult.observe(this, Observer { result ->
            result.onSuccess { loginResponse -> //成功
                //成功获取token和用户信息
                val token = loginResponse.data.token
                val customer = loginResponse.data.customer

                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
            }.onFailure { throwable -> //失败
                Toast.makeText(this, "登录失败:${throwable.message}", Toast.LENGTH_SHORT).show()
                Log.d("LoginMsg", "错误信息:${throwable.message}")
            }
        })

        //监听登录按钮
        binding.loginBtnLogin.setOnClickListener {
            //数据绑定为输入框
            val email = binding.loginEtUn.toString()
            val pwd = binding.loginEtPwd.toString()
            //调用view model里的登录方法
            viewModel.login(email, pwd)
        }

    }

    //页面退出
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