package com.yurvan.newsbinar.feature.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yurvan.newsbinar.core.network.service.NewsService
import com.yurvan.newsbinar.core.platform.BaseViewModel

import javax.inject.Inject

class ProfileViewModel  @Inject constructor(
    private val service: NewsService
)
    : BaseViewModel() {

    private val profile = MutableLiveData<Profile>()

    init { profile.postValue(Profile()) }

    fun getProfile(): LiveData<Profile> = profile
}