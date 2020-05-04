package com.sangeetha.dagger2.di.modules

import androidx.lifecycle.ViewModelProvider
import com.sangeetha.dagger2.di.ViewModelFactory.ApplicationViewModelFactory
import dagger.Binds
import dagger.Module
/*
        This Class is for providing dependencies for ViewModelFactory Class
 */
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindsViewModelFactory(factory: ApplicationViewModelFactory): ViewModelProvider.Factory

/*

    @Provides
    fun provideViewModelFactory(factory: ApplicationViewModelFactory): ViewModelProvider.Factory {
        return factory
    }

     */

    /*
        The above both function does the same thing but @Binds is more effecient way of doing because
        we dont need to write the body of that method.
     */
}