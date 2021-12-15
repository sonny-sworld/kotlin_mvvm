package com.emedinaa.kotlinmvvm.data

import com.emedinaa.kotlinmvvm.model.Museum

/**
 * Created by sgao on 15/12/2021 10:29
 **/
data class ResponseBean(val status: Int?, val msg: String? , val data: List<Museum>? )
{
    fun isSuccess():Boolean = status == 200
}
