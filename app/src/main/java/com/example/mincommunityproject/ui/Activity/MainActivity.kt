package com.example.mincommunityproject.ui.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mincommunityproject.R
import com.example.mincommunityproject.databinding.ActivityMainBinding
import com.example.mincommunityproject.model.MainItem
import com.example.mincommunityproject.ui.Adapter.MainItemAdapter
import com.example.mincommunityproject.viewmodel.MainViewModel
/**
 * 主页面
 * @author Min
 * @time 2024/6/2 20:18
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemAdapter: MainItemAdapter
    private lateinit var itemList: List<MainItem>
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //绑定页面
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        //获取ViewModel实例
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        //设置顶部颜色
        val window: Window = this@MainActivity.window
        window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.blue)

        binding.apply {
            // 设置底部菜单选中项为主页
            menu.setItemSelected(R.id.home)
            //底部菜单被点击时跳转相应的页面
            menu.setOnItemSelectedListener {
                viewModel?.selectMenuItem(it)
                when (it) {
                    R.id.Board -> startActivity(
                        Intent(
                            this@MainActivity,
                            CollectActivity::class.java
                        )
                    )

                    R.id.profile -> startActivity(
                        Intent(
                            this@MainActivity,
                            PersonageActivity::class.java
                        )
                    )

                    R.id.favorites -> startActivity(
                        Intent(
                            this@MainActivity,
                            MessageActivity::class.java
                        )
                    )
                }
            }
        }
        //头部标题变化
        setupTopItemSelection()

        //监听条目
        viewModel.itemList.observe(this, Observer { itemList ->
            Log.d("MainActivity", "Item list size:${itemList.size}")
            //绑定数据
            itemAdapter = MainItemAdapter(this@MainActivity, itemList)

            //绑定控件
            binding.lvMainItem.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = itemAdapter
            }
        })
    }

    private fun setupTopItemSelection() {
        // 将所有的Tab按钮添加点击事件
        listOf(
            binding.tvMainAttention,
            binding.tvMainQuestion,
            binding.tvMainLive,
            binding.tvMainStudy,
            binding.tvMainRecommend
        ).forEach { textView ->
            textView.setOnClickListener { setSelectedTab(textView) }
        }
    }

    private fun setSelectedTab(selectedTextView: TextView) {
        // 重置所有Tab的默认状态
        resetAllTabs()

        // 设置选中Tab的状态
        selectedTextView.apply {
            setTextColor(Color.BLACK)
            setTextSize(20F)
        }
    }

    private fun resetAllTabs() {
        // 重置所有Tab的状态
        listOf(
            binding.tvMainAttention,
            binding.tvMainQuestion,
            binding.tvMainLive,
            binding.tvMainStudy,
            binding.tvMainRecommend
        ).forEach { textView ->
            textView.apply {
                setTextColor(Color.GRAY)
                setTextSize(16F)
            }
        }
    }

}