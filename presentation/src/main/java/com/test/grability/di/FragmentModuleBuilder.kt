package com.test.grability.di

import com.test.grability.view.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModuleBuilder {


    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment
}
