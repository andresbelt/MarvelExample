package com.test.grability.domain.usecase

import com.test.grability.domain.repository.MarvelRepository
import com.test.grability.domain.vo.HttpResult
import javax.inject.Inject

class InsertCharactersUseCase @Inject constructor(private val repository: MarvelRepository) {

    suspend operator fun invoke(page : Int, onSuccessAction : () -> Unit, onErrorAction:  (cause : HttpResult, code : Int, errorMessage : String) -> Unit) {
        repository.getAllCharacters(page, onSuccessAction, onErrorAction)
    }

 }