package com.test.grability.data.di.modules

import android.content.Context
import androidx.room.Room
import com.test.grability.data.local.MarvelDatabase
import com.test.grability.data.vo.Constant
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @FeatureScope
    fun provideDatabase(context: Context) : MarvelDatabase = Room.databaseBuilder(context, MarvelDatabase::class.java, Constant.DATABASE_NAME)
        .build()
}