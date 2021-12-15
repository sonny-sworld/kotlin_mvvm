package com.emedinaa.kotlinmvvm.data

import retrofit2.Call
import retrofit2.http.GET


/**
 * Created by sgao on 15/12/2021 10:11
 **/
interface ApiInterface {
    @GET("/api/museums/")
    fun museums(): Call<MuseumResponse>
}