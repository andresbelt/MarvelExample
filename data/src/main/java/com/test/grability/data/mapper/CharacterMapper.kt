package com.test.grability.data.mapper

import com.test.grability.data.local.entity.CharacterEntity
import com.test.grability.data.remote.dto.CharactersDto
import com.test.grability.domain.entities.Characters

class CharacterMapper {

    fun map(input: CharactersDto): List<CharacterEntity> {
        val headlines = mutableListOf<CharacterEntity>()
        input.data?.results?.map {
            headlines.add(
                CharacterEntity(
                    it?.id ?: 0,
                    it?.thumbnail?.path+"."+it?.thumbnail?.extension?.replace("http://", "https://"),
                    it?.name ?: "",
                    it?.description  ?: "",
                    it?.modified  ?: ""
                )
            )
        }
        return headlines
    }

    fun mapToDomain(it: CharacterEntity): Characters {
        return Characters(
            it?.id,
            it?.thumbnail?.replace("http://", "https://"),
            it?.name ,
            it?.description,
            it?.modified
        )
    }
}