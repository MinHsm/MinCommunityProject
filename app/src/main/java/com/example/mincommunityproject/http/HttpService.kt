package com.example.mincommunityproject.http

import retrofit2.http.POST

interface HttpService {

    @POST("/account/login")
    fun LoginApp()
}