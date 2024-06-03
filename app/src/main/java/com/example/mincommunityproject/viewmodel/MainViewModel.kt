package com.example.mincommunityproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mincommunityproject.model.MainItem

/**
 * 主页面ViewModel
 * @author ming
 * @time 2024/6/3 10:03
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    //监听itemList列表
    private val _itemList = MutableLiveData<List<MainItem>>()
    val itemList: LiveData<List<MainItem>> get() = _itemList

    //监听底部导航栏
    private val _selectedMenuItem = MutableLiveData<Int>()
    val selectedMenuItem: LiveData<Int> get() = _selectedMenuItem

    init {
        //给itemList添加数据
        _itemList.value = generateMockData()
    }

    //添加数据的方法，将获取信息的Api写在里面
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

    //获取底部导航的值
    fun selectMenuItem(menuItemId: Int) {
        _selectedMenuItem.value = menuItemId
    }

}