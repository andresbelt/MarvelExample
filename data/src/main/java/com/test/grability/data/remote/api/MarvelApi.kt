package com.test.grability.data.remote.api

import com.test.grability.data.remote.dto.CharactersDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MarvelApi {

    @GET("/v1/public/characters")
    fun getCharactersAsync(@Query("offset") offset: Int): Call<CharactersDto>



}
