package com.yurvan.newsbinar.core.network.response

import com.yurvan.newsbinar.feature.home.model.Sources

data class SourceListResponse(
    val status: String?,
    val sources: List<Sources>
)