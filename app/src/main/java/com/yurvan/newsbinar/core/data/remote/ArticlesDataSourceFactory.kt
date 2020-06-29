package com.yurvan.newsbinar.core.data.remote

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.yurvan.newsbinar.core.network.service.NewsService
import com.yurvan.newsbinar.feature.home.model.Articles

import javax.inject.Inject


class ArticlesDataSourceFactory @Inject constructor(private val service: NewsService): DataSource.Factory<Int, Articles>() {

    private val dataSourceLiveData = MutableLiveData<ArticlesDataSource>()

    override fun create(): DataSource<Int, Articles> {
        val dataSource = ArticlesDataSource(service)
        dataSourceLiveData.postValue(dataSource)
        return dataSource
    }

}