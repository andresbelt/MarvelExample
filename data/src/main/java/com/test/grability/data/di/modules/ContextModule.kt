package com.test.grability.data.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule {
    @Provides
    @FeatureScope
    fun provideContext(app: Application): Context = app
}