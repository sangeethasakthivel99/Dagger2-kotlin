package com.sangeetha.dagger2.di.component

import android.app.Application
import com.sangeetha.dagger2.AppController
import com.sangeetha.dagger2.di.ViewModelFactory.ApplicationViewModelFactory
import com.sangeetha.dagger2.di.modules.AppModule
import com.sangeetha.dagger2.di.modules.ViewModelModule
import com.sangeetha.dagger2.features.Login.di.LoginActivityBuilder
import com.sangeetha.dagger2.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

/*
    @Component : The Module class doesn’t provide the dependency directly to the class that’s requesting it. For this,
     a Component interface is used that acts as a bridge between @Module and @Inject.
 */

/*
    we need to mention the Modules classes in the modules of @Component
 */

/*
    @ApplicationScope:
 */

@ApplicationScope
@Component(modules = [AndroidSupportInjectionModule::class,
LoginActivityBuilder::class, AppModule::class, ViewModelModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(appController: AppController)
}