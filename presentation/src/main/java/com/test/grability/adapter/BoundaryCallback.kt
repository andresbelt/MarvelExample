package com.test.grability.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.test.grability.domain.entities.Characters
import com.test.grability.domain.usecase.InsertCharactersUseCase
import com.test.grability.domain.vo.HttpResult
import com.test.grability.domain.vo.ResponseResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class BoundaryCallback(
    private val insertCharactersUseCase: InsertCharactersUseCase,
    private val scope : CoroutineScope
) : PagedList.BoundaryCallback<Characters>() {

    private val _newsState = MutableLiveData<ResponseResult<List<Characters>>>()
    val newsState : LiveData<ResponseResult<List<Characters>>> = _newsState

    private var isRequestInProgress = false
    private var lastRequestedPage = 0
    private var requestedPage = 0


    override fun onItemAtEndLoaded(itemAtEnd: Characters) {
        requestAndSaveData()
    }

    override fun onZeroItemsLoaded() {
        requestAndSaveData()
    }

    private fun requestAndSaveData() {
        if (isRequestInProgress) return

        setState(ResponseResult.Loading)

        scope.launch {

            insertCharactersUseCase(
                requestedPage,
                onSuccessAction = {onFetchSuccess()} ,
                onErrorAction = { cause, code, errorMessage ->  onFetchNewsError(cause, code, errorMessage)})
        }

    }

    private fun onFetchSuccess() {
        isRequestInProgress = false
        lastRequestedPage++
        requestedPage = lastRequestedPage*100
        setState(ResponseResult.Success(emptyList()))
    }
    private fun onFetchNewsError(cause : HttpResult, code : Int, errorMessage : String) {
        isRequestInProgress = false
        setState(ResponseResult.Error(cause, code, errorMessage))
    }

    private fun setState(result : ResponseResult<List<Characters>>) {
        _newsState.postValue(result)
    }

}