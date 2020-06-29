package com.yurvan.newsbinar.core.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.yurvan.newsbinar.core.di.ActivityScoped
import com.yurvan.newsbinar.feature.about.AboutActivity
import com.yurvan.newsbinar.feature.home.view.HomeActivity
import com.yurvan.newsbinar.feature.home.view.HomeActivityModule
import com.yurvan.newsbinar.feature.home.view.WebViewActivity


@Module
abstract class ActivityModule {
    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun contributeAboutActivity(): AboutActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun contributeHomeActivity(): HomeActivity


//    @ActivityScoped
//    @ContributesAndroidInjector()
//    abstract fun contributeProfileActivity(): ProfileActivity

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun contributeWebViewActivity(): WebViewActivity


}