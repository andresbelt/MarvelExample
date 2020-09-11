package com.test.grability.di

import com.test.grability.data.di.DataComponent
import com.test.grability.di.scopes.PerApplication
import dagger.Component
import dagger.android.AndroidInjectionModule

@PerApplication
@Component(
        dependencies = [(DataComponent::class)],
        modules = [
            AndroidInjectionModule::class,
            ContextModule::class,
            ActivityModuleBuilder::class,

            FragmentModuleBuilder::class,
            ViewModelModule::class
        ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            dataComponent: DataComponent
        ): AppComponent
    }
    fun inject(app: DaggerApplication)

}