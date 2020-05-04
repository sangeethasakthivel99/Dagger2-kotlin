package com.sangeetha.dagger2.features.Login.di

import com.sangeetha.dagger2.di.modules.ViewModelModule
import com.sangeetha.dagger2.di.scope.ActivityScope
import com.sangeetha.dagger2.features.Login.di.modules.LoginActivityModule
import com.sangeetha.dagger2.features.Login.di.modules.LoginPageViewModelModule
import com.sangeetha.dagger2.features.Login.view.activity.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/*
    @Module : This is used on the class that does the work of constructing objects
    and it will provide dependencies for  other classes
 */

/*
    @Provides : This is used on the methods inside the Module class that’ll return the object.
 */

@Module
abstract class LoginActivityBuilder {
    // We need to mention the module classes which has this activity scope in this module

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginPageViewModelModule::class, ViewModelModule::class, LoginActivityModule::class])
    abstract fun bindLoginActivity(): LoginActivity

    // by doing like this  view model module  has access only in the Login Activity, so that
    // we are saying that it has activity scope

}