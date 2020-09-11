package com.test.grability.data.remote


import com.test.grability.data.remote.RemoteDataSource
import com.test.grability.data.remote.api.MarvelApi
import com.test.grability.data.remote.dto.CharactersDto
import com.test.grability.domain.vo.ResponseResult
import kotlinx.coroutines.CoroutineDispatcher

class MarvelRemoteDataSource (private val api: MarvelApi) : RemoteDataSource() {

    suspend fun getAllCharacters(dispatcher: CoroutineDispatcher,offset: Int): ResponseResult<CharactersDto> {
        return safeApiCall(dispatcher) {  api.getCharactersAsync(offset).execute().body()!! }
    }

}