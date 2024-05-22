package com.example.mincommunityproject.ui.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mincommunityproject.R
import com.example.mincommunityproject.databinding.ActivityCollectBinding
import com.example.mincommunityproject.model.CollectUserModel
import com.example.mincommunityproject.ui.Adapter.CollectItemAdapter

class CollectActivity : AppCompatActivity() {
    lateinit var binding: ActivityCollectBinding
    private val leaderAdapter by lazy { CollectItemAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //设置顶部颜色
        val window = this@CollectActivity.window
        window.statusBarColor = ContextCompat.getColor(this@CollectActivity, R.color.blue)

        //给前三名设置头像和名字
        binding.apply {
            tvLlTop1.text = loadData().get(0).score.toString()
            tvLlTop2.text = loadData().get(1).score.toString()
            tvLlTop3.text = loadData().get(3).score.toString()
            titleTop1Txt.text = loadData().get(0).name
            titleTop2Txt.text = loadData().get(1).name
            titleTop3Txt.text = loadData().get(2).name

            val drawableResources1: Int = binding.root.resources.getIdentifier(
                loadData().get(0).pic, "drawable", binding.root.context.packageName
            )

            val drawableResources2: Int = binding.root.resources.getIdentifier(
                loadData().get(1).pic, "drawable", binding.root.context.packageName
            )

            val drawableResources3: Int = binding.root.resources.getIdentifier(
                loadData().get(2).pic, "drawable", binding.root.context.packageName
            )
            Glide.with(root.context).load(drawableResources3).into(sivTop3)
            Glide.with(root.context).load(drawableResources2).into(sivTop2)
            Glide.with(root.context).load(drawableResources1).into(sivTop1)

            //设置底部导航菜单的选中项
            bottomMenu.setItemSelected(R.id.Board)
            bottomMenu.setOnItemSelectedListener {
                if (it == R.id.home) {
                    startActivity(Intent(this@CollectActivity, MainActivity::class.java))
                } else if (it == R.id.profile) {
                    startActivity(Intent(this@CollectActivity, PersonageActivity::class.java))
                }
            }

            // 加载排名列表，去除前三名
            val list: MutableList<CollectUserModel> = loadData()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)
            leaderAdapter.differ.submitList(list)

            leaderView.apply {
                layoutManager = LinearLayoutManager(this@CollectActivity)
                adapter = leaderAdapter
            }

        }

    }

    // 加载示例数据，你可以从你的API服务中获取相似的数据列表
    private fun loadData(): MutableList<CollectUserModel> {
        val users: MutableList<CollectUserModel> = mutableListOf()
        users.add(CollectUserModel(1, "Min", "person1", 9850))
        users.add(CollectUserModel(2, "Davie", "person2", 8650))
        users.add(CollectUserModel(3, "Jason", "person3", 7950))
        users.add(CollectUserModel(4, "jame", "person4", 7850))
        users.add(CollectUserModel(5, "Mary", "person5", 5850))
        users.add(CollectUserModel(6, "Xs", "person6", 5450))
        users.add(CollectUserModel(7, "DaiDai", "person7", 4950))
        users.add(CollectUserModel(8, "DaiDai", "person8", 3950))
        users.add(CollectUserModel(9, "DaiDai", "person1", 2950))
        users.add(CollectUserModel(10, "DaiDai", "person2", 1950))
        users.add(CollectUserModel(11, "DaiDai", "person9", 950))
        return users
    }
}