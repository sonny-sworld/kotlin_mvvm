package com.emedinaa.kotlinmvvm.data

import com.emedinaa.kotlinmvvm.model.DataSourceInterface
import com.emedinaa.kotlinmvvm.model.Museum
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by sgao on 15/12/2021 10:34
 **/
class RemoteDataSource(apiClientTest : ApiClientTest): DataSourceInterface {
    private val apiService  = apiClientTest.buildService()
    var call: Call<MuseumResponse>? = null

    override fun retrieveRemoteData(callback : OperationCallback<Museum>) {
        call = apiService.museums()
        call?.enqueue(object: Callback<MuseumResponse>{
            override fun onResponse(
                call: Call<MuseumResponse>,
                response: Response<MuseumResponse>
            ) {
                response.body()?.run {
                    if(response.isSuccessful && isSuccess()) callback.onSuccess(data)
                    else callback.onError(msg)
                }
            }
            override fun onFailure(call: Call<MuseumResponse>, t: Throwable) {
                callback.onError(t.message)
            }
        })
    }

    override fun cancel() {
        call?.cancel()
    }

}