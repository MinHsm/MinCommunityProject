package com.example.mincommunityproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mincommunityproject.R
import java.time.format.TextStyle

class MainTitleViewModel : ViewModel() {

    val attentionStyle = MutableLiveData<TextStyle>()
    val recommendStyle = MutableLiveData<TextStyle>()
    val studyStyle = MutableLiveData<TextStyle>()
    val questionStyle = MutableLiveData<TextStyle>()
    val liveStyle = MutableLiveData<TextStyle>()

    init {
        // 初始化样式状态
        attentionStyle.value = TextStyle(14f, false, R.color.black)
        recommendStyle.value = TextStyle(20f, true, R.color.light_grey)
        studyStyle.value = TextStyle(14f, false, R.color.light_grey)
        questionStyle.value = TextStyle(14f, false, R.color.light_grey)
        liveStyle.value = TextStyle(14f, false, R.color.light_grey)
    }

    fun onAttentionClicked() {
        // 更新其他TextView的样式
        recommendStyle.value = TextStyle(14f, false, R.color.light_grey)
        studyStyle.value = TextStyle(14f, false, R.color.light_grey)
        questionStyle.value = TextStyle(14f, false, R.color.light_grey)
        liveStyle.value = TextStyle(14f, false, R.color.light_grey)

        // 更新tv_main_attention的样式
        attentionStyle.value = TextStyle(20f, true, R.color.black)
    }

    fun onRecommendClicked() {
        // 更新其他TextView的样式
        attentionStyle.value = TextStyle(14f, false, R.color.light_grey)
        studyStyle.value = TextStyle(14f, false, R.color.light_grey)
        questionStyle.value = TextStyle(14f, false, R.color.light_grey)
        liveStyle.value = TextStyle(14f, false, R.color.light_grey)

        // 更新tv_main_attention的样式
        recommendStyle.value = TextStyle(20f, true, R.color.black)
    }

    fun onStudyClicked() {
        // 更新其他TextView的样式
        recommendStyle.value = TextStyle(14f, false, R.color.light_grey)
        attentionStyle.value = TextStyle(14f, false, R.color.light_grey)
        questionStyle.value = TextStyle(14f, false, R.color.light_grey)
        liveStyle.value = TextStyle(14f, false, R.color.light_grey)

        // 更新tv_main_attention的样式
        studyStyle.value = TextStyle(20f, true, R.color.black)
    }

    fun onQuestionClicked() {
        // 更新其他TextView的样式
        recommendStyle.value = TextStyle(14f, false, R.color.light_grey)
        attentionStyle.value = TextStyle(14f, false, R.color.light_grey)
        studyStyle.value = TextStyle(14f, false, R.color.light_grey)
        liveStyle.value = TextStyle(14f, false, R.color.light_grey)

        // 更新tv_main_attention的样式
        questionStyle.value = TextStyle(20f, true, R.color.black)
    }

    fun onLiveClicked() {
        // 更新其他TextView的样式
        recommendStyle.value = TextStyle(14f, false, R.color.light_grey)
        attentionStyle.value = TextStyle(14f, false, R.color.light_grey)
        questionStyle.value = TextStyle(14f, false, R.color.light_grey)
        studyStyle.value = TextStyle(14f, false, R.color.light_grey)

        // 更新tv_main_attention的样式
        liveStyle.value = TextStyle(20f, true, R.color.black)
    }


    data class TextStyle(val textSize: Float, val isBold: Boolean, val textColor: Int)
}