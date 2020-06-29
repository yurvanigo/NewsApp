package com.yurvan.newsbinar.core.network.response

import com.yurvan.newsbinar.feature.home.model.Articles

data class ArticleListResponse(
    var status: String = "" ,
    var totalResults: Int = 0,
    val articles: List<Articles>
)