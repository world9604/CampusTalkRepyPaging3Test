package com.taein.paging3test.data.rx

import androidx.paging.PagingData
import com.taein.paging3test.data.model.Movies
import io.reactivex.Flowable
import kr.co.campustalk.data.dto.PostingReplyPagingDto

interface GetMoviesRxRepository {
    fun getMovies(postIdx: Long): Flowable<PagingData<Movies.Movie>>
}