package com.test.grability.util

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.test.grability.domain.entities.Characters
import com.test.grability.domain.vo.ResponseResult

data class SearchResult(val state :  LiveData<ResponseResult<List<Characters>>>, val characters : LiveData<PagedList<Characters>> )