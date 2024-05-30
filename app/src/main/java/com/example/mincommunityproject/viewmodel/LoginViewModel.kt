package com.example.mincommunityproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mincommunityproject.R

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val hintUsernameLogin: String = application.getString(R.string.hint_username_login)
    private val hintPasswordLogin: String = application.getString(R.string.hint_password_login)
    private val forgetPasswordLogin: String = application.getString(R.string.forget_password_login)
    private val hintUsernameRegister: String = application.getString(R.string.hint_username_register)
    private val hintPasswordRegister: String = application.getString(R.string.hint_password_register)
    private val forgetPasswordRegister: String = application.getString(R.string.forget_password_register)

    private val _isLoginMode = MutableLiveData(true)
    val isLoginMode: LiveData<Boolean> get() = _isLoginMode

    private val _hintUsername = MutableLiveData(hintUsernameLogin)
    val hintUsername: LiveData<String> get() = _hintUsername

    private val _hintPassword = MutableLiveData(hintPasswordLogin)
    val hintPassword: LiveData<String> get() = _hintPassword

    private val _forgetText = MutableLiveData(forgetPasswordLogin)
    val forgetText: LiveData<String> get() = _forgetText

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