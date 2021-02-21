package com.taein.campustalkrepypaging3test.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.taein.campustalkrepypaging3test.databinding.ItemPostingReplyBinding
import com.taein.campustalkrepypaging3test.databinding.ItemPostingReplyOfReplyBinding
import kr.co.campustalk.data.dto.PostingReplyDto


class PostingReplyAdapter(val itemClickListener: OnItemClickListener)
    : PagingDataAdapter<PostingReplyDto, PostingReplyBaseViewHolder>(
    POSTING_COMPARATOR
) {

    interface OnItemClickListener {
        fun onItemClick(v: View, replyIdx: Long)
        fun onClickedMoreBtn(v: View, replyIdx: Long)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostingReplyBaseViewHolder {
        when(viewType) {
            ReplyDepth.ONE.depthIntType -> {
                val binding = ItemPostingReplyBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                return PostingReplyViewHolder(
                    binding,
                    itemClickListener
                )
            }
            ReplyDepth.TWO.depthIntType -> {
                val binding = ItemPostingReplyOfReplyBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                return PostingReplyOfReplyViewHolder(
                    binding,
                    itemClickListener
                )
            }
            else -> {
                val binding = ItemPostingReplyBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                return PostingReplyViewHolder(
                    binding,
                    itemClickListener
                )
            }
        }
    }

    override fun onBindViewHolder(holder: PostingReplyBaseViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.depth ?: ReplyDepth.ONE.depthIntType
    }

    companion object {
        private val POSTING_COMPARATOR
                = object : DiffUtil.ItemCallback<PostingReplyDto>() {
            override fun areContentsTheSame(oldItem: PostingReplyDto, newItem: PostingReplyDto): Boolean =
                    oldItem.idx == newItem.idx

            override fun areItemsTheSame(oldItem: PostingReplyDto, newItem: PostingReplyDto): Boolean =
                    oldItem.idx == newItem.idx
        }
    }
}

abstract class PostingReplyBaseViewHolder(
    private val binding: ViewDataBinding,
    private val itemListener: PostingReplyAdapter.OnItemClickListener
)
    : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(reply: PostingReplyDto)
}

class PostingReplyViewHolder(
        private val binding: ItemPostingReplyBinding,
        private val itemListener: PostingReplyAdapter.OnItemClickListener
)
    : PostingReplyBaseViewHolder(binding, itemListener) {

    override fun bind(reply: PostingReplyDto) {
        binding.reply = reply
    }
}

class PostingReplyOfReplyViewHolder(
        private val binding: ItemPostingReplyOfReplyBinding,
        private val itemListener: PostingReplyAdapter.OnItemClickListener
)
    : PostingReplyBaseViewHolder(binding, itemListener) {

    override fun bind(reply: PostingReplyDto) {
        binding.reply = reply
    }
}

enum class ReplyDepth(val depthIntType: Int) {
    ONE(1), TWO(2);
}