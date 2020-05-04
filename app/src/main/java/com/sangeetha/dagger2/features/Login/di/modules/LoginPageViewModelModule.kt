package com.sangeetha.dagger2.features.Login.di.modules

import androidx.lifecycle.ViewModel
import com.sangeetha.dagger2.di.ViewModelKey
import com.sangeetha.dagger2.features.Login.viewmodels.LoginActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginPageViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey( LoginActivityViewModel::class)
    abstract fun bindLoginActivityViewModel( loginActivityViewModel: LoginActivityViewModel): ViewModel
}