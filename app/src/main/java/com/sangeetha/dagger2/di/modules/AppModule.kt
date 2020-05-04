package com.sangeetha.dagger2.di.modules

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.sangeetha.dagger2.R
import dagger.Module
import dagger.Provides

/*
    This class is for providing application level dependencies like shared Preference instance
    and Retrofit instance
 */
@Module
class AppModule {

    @Provides
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions.placeholderOf(R.drawable.background_white)
            .error(R.drawable.background_white)
    }

    @Provides
    fun provideGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }

    @Provides
    fun provideAppDrawable(application: Application): Drawable {
        return ContextCompat.getDrawable(application,
            R.drawable.ic_logo
        )!!
    }
}