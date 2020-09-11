package com.test.grability.data.local.dao

import androidx.paging.DataSource
import androidx.room.*
import com.test.grability.data.local.entity.CharacterEntity
import com.test.grability.domain.entities.Characters

@Dao
abstract class MarvelDao {

    @Query("SELECT * FROM characters ORDER BY name")
    abstract fun findAll(): DataSource.Factory<Int, CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insertAll(newsChannels: List<CharacterEntity>)
}