package com.emedinaa.kotlinmvvm.model

import com.emedinaa.kotlinmvvm.data.OperationCallback

/**
 * @author Eduardo Medina
 */
interface MuseumDataSourceInterface {

    fun retrieveMuseums(callback: OperationCallback<Museum>)
    fun cancel()
}