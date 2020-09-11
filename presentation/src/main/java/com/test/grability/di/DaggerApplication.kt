package com.test.grability.di

import android.app.Application
import androidx.annotation.VisibleForTesting
import com.test.grability.data.di.DaggerDataComponent
import com.test.grability.data.di.DataComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class DaggerApplication : Application(),HasAndroidInjector {


    @VisibleForTesting
    val dataComponent: DataComponent by lazy { DaggerDataComponent.factory().create(baseContext) }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>


    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.factory()
            .create(dataComponent).inject(this)
    }
    }



