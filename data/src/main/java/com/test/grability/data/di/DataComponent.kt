package com.test.grability.data.di

import android.content.Context
import com.test.grability.data.di.modules.*
import com.test.grability.data.local.MarvelDatabase
import com.test.grability.dispatcher.DispatcherProvider
import com.test.grability.domain.repository.MarvelRepository
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@FeatureScope
@Component(
    modules = [
        NetworkModule::class,
        CharacterModule::class,
        DatabaseModule::class,
        RepositoryModule::class,
        CoroutineDispatcherModule::class
    ]
)
interface DataComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): DataComponent
    }

    fun marvelDatabase() : MarvelDatabase
    fun retrofit() : Retrofit
    fun dispatcher() : DispatcherProvider
    // Exposed to sub-graphs
    fun provideRepoRepository(): MarvelRepository
}