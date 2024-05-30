package com.example.mincommunityproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mincommunityproject.model.MainItem

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _itemList = MutableLiveData<List<MainItem>>()
    val itemList: LiveData<List<MainItem>> get() = _itemList

    private val _selectedMenuItem = MutableLiveData<Int>()
    val selectedMenuItem: LiveData<Int> get() = _selectedMenuItem

    init {
        _itemList.value = generateMockData()
    }

    private fun generateMockData(): List<MainItem> {
        return listOf(
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏"),
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏"),
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏"),
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏"),
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏"),
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏"),
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏"),
            MainItem("Min", "Android ViewList如何使用", "71浏览", "4点赞", "5收藏")
        )
    }

    fun selectMenuItem(menuItemId: Int) {
        _selectedMenuItem.value = menuItemId
    }

}