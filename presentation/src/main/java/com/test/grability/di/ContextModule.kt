package com.test.grability.di

import android.app.Application
import android.content.Context
import com.test.grability.di.scopes.PerApplication
import dagger.Module
import dagger.Provides

@Module
class ContextModule {

    @Provides
    @PerApplication
    internal fun provideContext(application: Application): Context = application.baseContext
}
