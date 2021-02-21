package com.taein.paging3test.data.rx

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.flowable
import com.taein.paging3test.data.model.Movies
import com.taein.paging3test.data.rx.GetMoviesRxPagingSource
import com.taein.paging3test.data.rx.GetMoviesRxRepository
import io.reactivex.Flowable
import kr.co.campustalk.data.dto.PostingReplyDto
import kr.co.campustalk.data.dto.PostingReplyPagingDto

class GetReplysRxRepositoryImpl(private val pagingSource: GetReplysRxPagingSource):
    GetReplysRxRepository {

    override fun getReplys(): Flowable<PagingData<PostingReplyDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                maxSize = 30,
                prefetchDistance = 5,
                initialLoadSize = 40),
            pagingSourceFactory = { pagingSource }
        ).flowable
    }
}