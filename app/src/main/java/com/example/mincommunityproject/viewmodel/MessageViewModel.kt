package com.example.mincommunityproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mincommunityproject.model.MainItem
import com.example.mincommunityproject.model.MsgItemModel
/**
 * 消息页面ViewModel
 * @author ming
 * @time 2024/6/3 10:06
 */
class MessageViewModel(application: Application) : AndroidViewModel(application) {

    //监听
    private val _itemList = MutableLiveData<List<MainItem>>()
    val itemList: LiveData<List<MainItem>> get() = _itemList

    private val _selectedMenuItem = MutableLiveData<Int>()
    val selectedMenuItem: LiveData<Int> get() = _selectedMenuItem

    //获取底部导航的值
    fun selectMenuItem(menuItemId: Int) {
        _selectedMenuItem.value = menuItemId
    }

    // 加载示例数据，你可以从你的API服务中获取相似的数据列表
    fun loadMessageList(): List<MsgItemModel> {
        val users: MutableList<MsgItemModel> = mutableListOf()
        users.add(
            MsgItemModel(
                "Min",
                "person1",
                "04-05",
                "你好！三大队三大队大多数夫妻大发放发放搜房网"
            )
        )
        users.add(
            MsgItemModel(
                "Min",
                "person1",
                "04-05",
                "你好！三大队三大队大多数夫妻大发放发放搜房网"
            )
        )
        users.add(
            MsgItemModel(
                "Min",
                "person1",
                "04-05",
                "你好！三大队三大队大多数夫妻大发放发放搜房网"
            )
        )
        users.add(
            MsgItemModel(
                "Min",
                "person1",
                "04-05",
                "你好！三大队三大队大多数夫妻大发放发放搜房网"
            )
        )
        users.add(
            MsgItemModel(
                "Min",
                "person1",
                "04-05",
                "你好！三大队三大队大多数夫妻大发放发放搜房网"
            )
        )
        users.add(
            MsgItemModel(
                "Min",
                "person1",
                "04-05",
                "你好！三大队三大队大多数夫妻大发放发放搜房网"
            )
        )

        return users
    }


}