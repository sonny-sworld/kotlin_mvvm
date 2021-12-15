package com.emedinaa.kotlinmvvm.model

import com.emedinaa.kotlinmvvm.data.OperationCallback

/**
 * @author Eduardo Medina
 */
class Repository(private val mDataSource: DataSourceInterface) {

    fun fetchMuseums(callback: OperationCallback<Museum>) {
        mDataSource.retrieveRemoteData(callback)
    }

    fun cancel() {
        mDataSource.cancel()
    }
}