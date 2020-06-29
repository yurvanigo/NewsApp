package com.yurvan.newsbinar.core.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import com.yurvan.newsbinar.core.di.module.ActivityModule
import com.yurvan.newsbinar.core.di.module.AppModule
import com.yurvan.newsbinar.core.di.module.NetworkModule
import com.yurvan.newsbinar.core.di.module.ViewModelModule
import com.yurvan.newsbinar.core.platform.BaseApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: BaseApplication)

    override fun inject(instance: DaggerApplication?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}