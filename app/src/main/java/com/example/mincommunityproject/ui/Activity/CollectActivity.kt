package com.example.mincommunityproject.ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.mincommunityproject.R
import com.example.mincommunityproject.databinding.ActivityCollectBinding
import com.example.mincommunityproject.ui.Adapter.CollectItemAdapter

class CollectActivity : AppCompatActivity() {
    lateinit var binding: ActivityCollectBinding
    private val leaderAdapter by lazy { CollectItemAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window = this@CollectActivity.window
        window.statusBarColor = ContextCompat.getColor(this@CollectActivity, R.color.grey)
        
    }
}