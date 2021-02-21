package com.taein.paging3test.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.taein.paging3test.data.rx.GetMoviesRxRepository
import com.taein.paging3test.data.rx.GetReplysRxRepository

class GetReplysRxViewModelFactory(private val repository: GetReplysRxRepository): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GetReplysRxViewModel::class.java)) {
            return GetReplysRxViewModel(
                repository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}