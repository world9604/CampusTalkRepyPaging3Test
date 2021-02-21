package com.taein.paging3test.view.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.rxjava2.cachedIn
import com.taein.paging3test.data.model.Movies
import com.taein.paging3test.data.rx.GetMoviesRxRepository
import com.taein.paging3test.data.rx.GetReplysRxRepository
import io.reactivex.Flowable
import kr.co.campustalk.data.dto.PostingReplyDto
import kr.co.campustalk.data.dto.PostingReplyPagingDto

class GetReplysRxViewModel(private val repository: GetReplysRxRepository) : ViewModel() {

    fun getReplys(replyIdx: Long): Flowable<PagingData<PostingReplyDto>> {
        return repository
            .getReplys()
            .map { pagingData ->
                pagingData.filter {
//                    Log.d("reply", "reply idx : ${it.idx}, parent idx : ${it.parent_idx}, depth : ${it.depth}")
                    // 사용자가 선택한 댓글의 댓글
                    it.parent_idx == replyIdx ||
                    // depth 가 1 인 댓글
                    it.depth == 1
                }
            }
            .cachedIn(viewModelScope)
    }
}