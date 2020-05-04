package com.sangeetha.dagger2

import android.app.Activity
import android.app.Application
import com.sangeetha.dagger2.di.component.AppComponent
import com.sangeetha.dagger2.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class AppController: Application(), HasActivityInjector {
    private lateinit var appComponent: AppComponent

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        setupAppComponent()
    }

    private fun setupAppComponent() {
        appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}