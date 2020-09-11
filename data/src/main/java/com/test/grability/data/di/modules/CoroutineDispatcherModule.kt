package com.test.grability.data.di.modules

import com.test.grability.dispatcher.CoroutineDispatcherProvider
import com.test.grability.dispatcher.DispatcherProvider
import dagger.Binds
import dagger.Module


@Module
interface CoroutineDispatcherModule {
    @Binds
    fun bindDispatcher(dispatcherProvider: CoroutineDispatcherProvider) : DispatcherProvider
}