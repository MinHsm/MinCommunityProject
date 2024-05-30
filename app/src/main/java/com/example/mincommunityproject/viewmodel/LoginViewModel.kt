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

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val hintUsernameLogin: String = application.getString(R.string.hint_username_login)
    private val hintPasswordLogin: String = application.getString(R.string.hint_password_login)
    private val forgetPasswordLogin: String = application.getString(R.string.forget_password_login)
    private val hintUsernameRegister: String =
        application.getString(R.string.hint_username_register)
    private val hintPasswordRegister: String =
        application.getString(R.string.hint_password_register)
    private val forgetPasswordRegister: String =
        application.getString(R.string.forget_password_register)

    private val _isLoginMode = MutableLiveData(true)
    val isLoginMode: LiveData<Boolean> get() = _isLoginMode

    private val _hintUsername = MutableLiveData(hintUsernameLogin)
    val hintUsername: LiveData<String> get() = _hintUsername

    private val _hintPassword = MutableLiveData(hintPasswordLogin)
    val hintPassword: LiveData<String> get() = _hintPassword

    private val _forgetText = MutableLiveData(forgetPasswordLogin)
    val forgetText: LiveData<String> get() = _forgetText

    private val _loginResult = MutableLiveData<Result<LoginResponse>>()
    val loginResult: LiveData<Result<LoginResponse>> get() = _loginResult

    private var apiService: HttpService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(HttpService::class.java)
    }

    fun login(nameOrEmail: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = apiService.login(nameOrEmail, password).execute()
                if (response.isSuccessful) {
                    _loginResult.postValue(Result.success(response.body()) as Result<LoginResponse>?)
                } else {
                    _loginResult.postValue(Result.failure(Exception("Login failed with status: ${response.code()}")))
                }
            } catch (e: Exception) {
                _loginResult.postValue(Result.failure(e))
            }
        }
    }

    fun switchToLoginMode() {
        _isLoginMode.value = true
        _hintUsername.value = hintUsernameLogin
        _hintPassword.value = hintPasswordLogin
        _forgetText.value = forgetPasswordLogin
    }

    fun switchToRegisterMode() {
        _isLoginMode.value = false
        _hintUsername.value = hintUsernameRegister
        _hintPassword.value = hintPasswordRegister
        _forgetText.value = forgetPasswordRegister
    }

}