package kr.co.campustalk.data.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostingReplyPagingDto (

        @Expose
        @SerializedName("items")
        val postingReplyList: List<PostingReplyDto> = mutableListOf(),

        // "page": 1,
        @Expose
        @SerializedName("page")
        val page: Int,

        // "count": 20,
        @Expose
        @SerializedName("count")
        val count: Int,

        // "total_count": 83,
        @Expose
        @SerializedName("total_count")
        val total_count: Int,

        // "last": 5
        @Expose
        @SerializedName("last")
        val last: Int
)