package com.taein.paging3test.view

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.taein.paging3test.view.viewholder.LoadingGridStateViewHolder

class LoadingGridStateAdapter: LoadStateAdapter<LoadingGridStateViewHolder>() {
    override fun onBindViewHolder(holder: LoadingGridStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadingGridStateViewHolder {
        return LoadingGridStateViewHolder.create(
            parent
        )
    }
}