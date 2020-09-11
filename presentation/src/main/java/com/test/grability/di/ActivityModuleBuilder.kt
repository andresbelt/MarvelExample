package com.test.grability.di

import com.test.grability.view.activity.LoginActivity
import com.test.grability.view.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModuleBuilder {
    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity


}
