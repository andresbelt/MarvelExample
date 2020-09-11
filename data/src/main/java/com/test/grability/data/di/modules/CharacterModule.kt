package com.test.grability.data.di.modules

import com.test.grability.data.remote.MarvelRemoteDataSource
import com.test.grability.data.local.MarvelDatabase
import com.test.grability.data.local.dao.MarvelDao
import com.test.grability.data.mapper.CharacterMapper
import com.test.grability.data.remote.api.MarvelApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class CharacterModule {

    @Provides
    @FeatureScope
    fun provideNewseDao(db: MarvelDatabase) : MarvelDao = db.newsDao()

    @Provides
    @FeatureScope
    fun provideMapper() : CharacterMapper = CharacterMapper()

    @Provides
    @FeatureScope
    fun provideMarvelApi(retrofit: Retrofit) : MarvelApi = retrofit.create(MarvelApi::class.java)

    @Provides
    @FeatureScope
    fun provideMarvelRemoteDataSource(characterService: MarvelApi) = MarvelRemoteDataSource(characterService)
}