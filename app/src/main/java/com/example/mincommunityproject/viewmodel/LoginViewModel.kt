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

    //初始化信息
    private val hintUsernameLogin: String = application.getString(R.string.hint_username_login)
    private val hintPasswordLogin: String = application.getString(R.string.hint_password_login)
    private val forgetPasswordLogin: String = application.getString(R.string.forget_password_login)
    private val hintUsernameRegister: String =
        application.getString(R.string.hint_username_register)
    private val hintPasswordRegister: String =
        application.getString(R.string.hint_password_register)
    private val forgetPasswordRegister: String =
        application.getString(R.string.forget_password_register)

    // LiveData 用于监控登录模式状态
    private val _isLoginMode = MutableLiveData(true)
    val isLoginMode: LiveData<Boolean> get() = _isLoginMode

    // LiveData 用于监控用户名提示
    private val _hintUsername = MutableLiveData(hintUsernameLogin)
    val hintUsername: LiveData<String> get() = _hintUsername

    // LiveData 用于监控密码提示
    private val _hintPassword = MutableLiveData(hintPasswordLogin)
    val hintPassword: LiveData<String> get() = _hintPassword

    // 监控忘记密码文本
    private val _forgetText = MutableLiveData(forgetPasswordLogin)
    val forgetText: LiveData<String> get() = _forgetText

    //监控登录结果
    private val _loginResult = MutableLiveData<Result<LoginResponse>>()
    val loginResult: LiveData<Result<LoginResponse>> get() = _loginResult

    //API服务接口
    private var apiService: HttpService

    init {
        //初始化 Rerofit
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
                if (response.isSuccessful) {
                    // 登录成功，更新 LiveData
                    _loginResult.postValue(Result.success(response.body()) as Result<LoginResponse>?)
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

    //改变为login视图
    fun switchToLoginMode() {
        _isLoginMode.value = true
        _hintUsername.value = hintUsernameLogin
        _hintPassword.value = hintPasswordLogin
        _forgetText.value = forgetPasswordLogin
    }

    //改变Register视图
    fun switchToRegisterMode() {
        _isLoginMode.value = false
        _hintUsername.value = hintUsernameRegister
        _hintPassword.value = hintPasswordRegister
        _forgetText.value = forgetPasswordRegister
    }

}