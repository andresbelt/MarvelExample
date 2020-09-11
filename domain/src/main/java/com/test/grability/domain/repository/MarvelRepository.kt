package com.test.grability.domain.repository

import androidx.paging.DataSource
import com.test.grability.domain.entities.Characters
import com.test.grability.domain.vo.HttpResult


interface MarvelRepository {
    suspend fun getAllCharacters(page: Int, onSuccessAction : () -> Unit,
                                 onErrorAction: (cause : HttpResult, code : Int, errorMessage : String) -> Unit)

    fun findAll() : DataSource.Factory<Int, Characters>
}

