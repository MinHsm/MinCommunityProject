package com.example.mincommunityproject.ui.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mincommunityproject.R
import com.example.mincommunityproject.databinding.ActivityMessageBinding
import com.example.mincommunityproject.model.CollectUserModel
import com.example.mincommunityproject.model.MsgItemModel
import com.example.mincommunityproject.ui.Adapter.MsgItemAdapter
import com.example.mincommunityproject.viewmodel.MessageViewModel
/**
 * 消息页面
 * @author Min
 * @time 2024/6/2 20:35
 */
class MessageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMessageBinding
    private val msgItemAdapter by lazy { MsgItemAdapter() }
    private lateinit var viewModel: MessageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //绑定xml文件
        binding = DataBindingUtil.setContentView(this, R.layout.activity_message)
        binding.lifecycleOwner = this

        //绑定viewmodel
        viewModel = ViewModelProvider(this).get(MessageViewModel::class.java)

        //设置顶部颜色
        val window: Window = this@MessageActivity.window
        window.statusBarColor = ContextCompat.getColor(this@MessageActivity, R.color.blue)

        binding.apply {
            // 设置底部菜单选中项为主页
            menu.setItemSelected(R.id.favorites)
            //设置跳转
            menu.setOnItemSelectedListener {
                viewModel?.selectMenuItem(it)
                when (it) {
                    R.id.Board -> startActivity(
                        Intent(
                            this@MessageActivity,
                            CollectActivity::class.java
                        )
                    )

                    R.id.home -> startActivity(
                        Intent(
                            this@MessageActivity,
                            MainActivity::class.java
                        )
                    )

                    R.id.profile -> startActivity(
                        Intent(
                            this@MessageActivity,
                            PersonageActivity::class.java
                        )
                    )
                }
            }

            //绑定条目数据
            val list = viewModel.loadMessageList()
            msgItemAdapter.differ.submitList(list)

            //绑定条目控件
            msgRvItem.apply {
                layoutManager = LinearLayoutManager(this@MessageActivity)
                adapter = msgItemAdapter
            }
        }
    }


}