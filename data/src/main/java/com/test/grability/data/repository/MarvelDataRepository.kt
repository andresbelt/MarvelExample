package com.test.grability.data.repository


import androidx.paging.DataSource
import com.test.grability.data.remote.MarvelRemoteDataSource
import com.test.grability.data.local.dao.MarvelDao
import com.test.grability.data.mapper.CharacterMapper
import com.test.grability.dispatcher.DispatcherProvider
import com.test.grability.domain.entities.Characters
import com.test.grability.domain.repository.MarvelRepository
import com.test.grability.domain.vo.HttpResult
import com.test.grability.domain.vo.ResponseResult
import javax.inject.Inject

class MarvelDataRepository @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val mapper: CharacterMapper,
    private val dao: MarvelDao,
    private val remoteDataSource: MarvelRemoteDataSource
) : MarvelRepository {


    override suspend fun getAllCharacters(
        page: Int,
        onSuccessAction: () -> Unit,
        onErrorAction: (cause: HttpResult, code: Int, errorMessage: String) -> Unit
    ) {
        val apiResult = remoteDataSource.getAllCharacters(dispatcher.io, page)
        when(apiResult) {
            is ResponseResult.Success -> {
                onSuccessAction()
                val news =  mapper.map(apiResult.data)
                dao.insertAll(news)
            }
            is ResponseResult.Error -> {
                onErrorAction(apiResult.cause, apiResult.code ?: 0, apiResult.errorMessage ?: "")
            }
        }
    }

    override fun findAll(): DataSource.Factory<Int, Characters> {
        return dao.findAll().map {
            mapper.mapToDomain(it)
        }
    }


}