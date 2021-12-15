package com.emedinaa.kotlinmvvm.model

import com.emedinaa.kotlinmvvm.data.OperationCallback

/**
 * Created by sgao on 15/12/2021 10:41
 **/
interface DataSourceInterface {
    fun retrieveRemoteData(callback: OperationCallback<Museum>)
    fun cancel()
}