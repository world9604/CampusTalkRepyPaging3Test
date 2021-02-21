package com.taein.paging3test.data.rx

import androidx.paging.PagingData
import com.taein.paging3test.data.model.Movies
import io.reactivex.Flowable
import kr.co.campustalk.data.dto.PostingReplyDto
import kr.co.campustalk.data.dto.PostingReplyPagingDto

interface GetReplysRxRepository {
    fun getReplys(): Flowable<PagingData<PostingReplyDto>>
}