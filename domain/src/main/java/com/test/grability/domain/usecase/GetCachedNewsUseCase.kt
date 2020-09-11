package com.test.grability.domain.usecase

import com.test.grability.domain.entities.Characters
import com.test.grability.domain.repository.MarvelRepository
import com.test.grability.domain.vo.ResponseResult
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(private val repository: MarvelRepository) {

     operator fun invoke() =
        repository.findAll()


}