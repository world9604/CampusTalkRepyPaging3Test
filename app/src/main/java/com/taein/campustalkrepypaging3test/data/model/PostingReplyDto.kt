package kr.co.campustalk.data.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostingReplyDto (

        //"idx": 3,
        @Expose
        @SerializedName("idx")
        var idx: Long = 0,

        // "member_idx": 24722,
        @Expose
        @SerializedName("member_idx")
        val member_idx: Long = 0,

        //"nickname": "juse304",
        @Expose
        @SerializedName("nickname")
        val nickname: String = "",

        // "profile_image": null,
        @Expose
        @SerializedName("profile_image")
        val profile_image: String = "",

        // "parent_idx": 55,
        @Expose
        @SerializedName("parent_idx")
        val parent_idx: Long = 0,

        // "target_idx": null,
        @Expose
        @SerializedName("target_idx")
        val target_idx: Long = 0,

        // "target_nickname": null,
        @Expose
        @SerializedName("target_nickname")
        val target_nickname: String = "",

        // "content": "ngon vãi",
        @Expose
        @SerializedName("content")
        var content: String = "",

        // "depth": 2,
        @Expose
        @SerializedName("depth")
        val depth: Int = 0,

        // "created_at": 1608869216000,
        @Expose
        @SerializedName("created_at")
        val created_at: Long = 0,

        // "child_count": 4
        @Expose
        @SerializedName("child_count")
        val child_count: Long = 0
)