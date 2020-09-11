package com.test.grability.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.grability.data.local.dao.MarvelDao
import com.test.grability.data.local.entity.CharacterEntity


@Database(entities = [CharacterEntity::class], version = 1)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun newsDao(): MarvelDao
}