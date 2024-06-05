package com.example.mincommunityproject.viewmodel

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mincommunityproject.R
import com.example.mincommunityproject.http.HttpService
import com.example.mincommunityproject.model.LoginResponse
import com.example.mincommunityproject.util.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.Exception

/**
 * 登录的viewmodel
 * @author ming
 * @time 2024/6/3 09:58
 */
class LoginViewModel(application: Application) : AndroidViewModel(application) {

    //监控登录结果
    private val _loginResult = MutableLiveData<Result<LoginResponse>>()
    val loginResult: LiveData<Result<LoginResponse>> get() = _loginResult

    //API服务接口
    private var apiService: HttpService

    init {
        //初始化 Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //创建HttpService实例
        apiService = retrofit.create(HttpService::class.java)
    }

    //登录方法
    fun login(nameOrEmail: String, password: String) {
        // 在 IO 线程中执行网络请求
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = apiService.login(nameOrEmail, password).execute()
                if (response.isSuccessful && response.body() != null) {
                    // 登录成功，更新 LiveData
                    val loginResponse = response.body()!!
                    _loginResult.postValue(Result.success(loginResponse))
                } else {
                    // 登录失败，更新 LiveData
                    _loginResult.postValue(Result.failure(Exception("Login failed with status: ${response.code()}")))
                }
            } catch (e: Exception) {
                // 捕获异常，更新 LiveData
                _loginResult.postValue(Result.failure(e))
            }
        }
    }

}