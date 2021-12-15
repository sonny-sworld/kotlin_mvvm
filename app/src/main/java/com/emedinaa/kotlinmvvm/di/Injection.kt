package com.emedinaa.kotlinmvvm.di

import com.emedinaa.kotlinmvvm.data.ApiClientTest
import com.emedinaa.kotlinmvvm.data.RemoteDataSource
import com.emedinaa.kotlinmvvm.model.DataSourceInterface
import com.emedinaa.kotlinmvvm.model.Repository
import com.emedinaa.kotlinmvvm.viewmodel.ViewModelFactory

/**
 * @author Eduardo Medina
 */
object Injection {

    private var museumDataSource: DataSourceInterface? = null
    private var mRepository: Repository? = null
    private var viewModelFactory: ViewModelFactory? = null

    private fun createMuseumDataSource(): DataSourceInterface {
        val dataSource = RemoteDataSource(ApiClientTest)
        museumDataSource = dataSource
        return dataSource
    }

    private fun createMuseumRepository(): Repository {
        val repository = Repository(provideDataSource())
        mRepository = repository
        return repository
    }

    private fun createFactory(): ViewModelFactory {
        val factory = ViewModelFactory(providerRepository())
        viewModelFactory = factory
        return factory
    }

    private fun provideDataSource() = museumDataSource ?: createMuseumDataSource()
    private fun providerRepository() = mRepository ?: createMuseumRepository()

    fun provideViewModelFactory() = viewModelFactory ?: createFactory()

    fun destroy() {
        museumDataSource = null
        mRepository = null
        viewModelFactory = null
    }
}