package com.test.grability.data.di.modules

import com.test.grability.data.repository.MarvelDataRepository
import com.test.grability.domain.repository.MarvelRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
interface RepositoryModule {

    @Binds
    fun bindRepository(repository: MarvelDataRepository): MarvelRepository
}