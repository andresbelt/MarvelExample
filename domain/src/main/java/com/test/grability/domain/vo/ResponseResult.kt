package com.test.grability.domain.vo


sealed class ResponseResult<out T> {
    object Loading : ResponseResult<Nothing>()
    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Error(val cause: HttpResult, val code : Int? = null, val errorMessage : String? = null) : ResponseResult<Nothing>()
}