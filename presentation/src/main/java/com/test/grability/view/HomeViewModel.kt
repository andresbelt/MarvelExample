package com.test.grability.view

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.test.grability.util.SearchResult
import com.test.grability.adapter.BoundaryCallback
import com.test.grability.domain.entities.Characters
import com.test.grability.domain.usecase.GetAllCharactersUseCase
import com.test.grability.domain.usecase.InsertCharactersUseCase
import com.test.grability.domain.vo.ResponseResult
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getAllCharacters: GetAllCharactersUseCase,
    private val insertCharactersUseCase: InsertCharactersUseCase
) : ViewModel() {

    companion object {
        const val PAGE_SIZE = 10
    }

    private val _query = MutableLiveData<String>()
    private val searchResult = Transformations.map(_query) {
        search()
    }

    val news = Transformations.switchMap(searchResult) { it.characters }
    val searchState : LiveData<ResponseResult<List<Characters>>> = Transformations.switchMap(searchResult) { it.state }

    fun setSearchQuery() {
        _query.postValue("")
    }

    fun search(): SearchResult = runBlocking {
        val factory = getAllCharacters().map {
            it
        }
        val boundaryCallback = BoundaryCallback( insertCharactersUseCase, viewModelScope)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(2 * PAGE_SIZE)
            .setPageSize(PAGE_SIZE)
            .build()

        var newsSource = LivePagedListBuilder(factory, config)
            .setBoundaryCallback(boundaryCallback)
            .build()
        val newsSourceState = boundaryCallback.newsState


        SearchResult(newsSourceState, newsSource)
    }




}