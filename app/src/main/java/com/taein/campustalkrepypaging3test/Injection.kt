package com.adrena.commerce.paging3.data

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.taein.campustalkrepypaging3test.R
import com.taein.paging3test.data.TMDBService
import com.taein.paging3test.data.model.MoviesMapper
import com.taein.paging3test.data.rx.GetMoviesRxPagingSource
import com.taein.paging3test.data.rx.GetMoviesRxRepositoryImpl
import com.taein.paging3test.data.rx.GetReplysRxPagingSource
import com.taein.paging3test.data.rx.GetReplysRxRepositoryImpl
import com.taein.paging3test.view.viewmodel.GetReplysRxViewModelFactory
import java.util.*

object Injection {

    fun provideRxViewModel(postIdx: Long): ViewModelProvider.Factory {
        val pagingSource =
            GetReplysRxPagingSource(
                service = TMDBService.create(),
                postIdx = postIdx,
                page = 1,
                count = 20
            )

        val repository =
            GetReplysRxRepositoryImpl(
                pagingSource = pagingSource
            )

        return GetReplysRxViewModelFactory(
            repository
        )
    }
}