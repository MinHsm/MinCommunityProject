package com.example.mincommunityproject.http

import com.example.mincommunityproject.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface HttpService {

    @FormUrlEncoded
    @POST("/account/login")
    fun login(
        @Field("nameOrEmail") nameOrEmail: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}