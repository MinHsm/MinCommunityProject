package com.example.mincommunityproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PersonageViewModel(application: Application) : AndroidViewModel(application) {

    private val _selectedMenuItem = MutableLiveData<Int>()
    val selectedMenuItem: LiveData<Int> get() = _selectedMenuItem

    fun selectMenuItem(menuItemId: Int) {
        _selectedMenuItem.value = menuItemId
    }

}