package com.taein.paging3test.data

import com.taein.paging3test.data.model.MoviesResponse
import io.reactivex.Single
import kr.co.campustalk.data.dto.PostingReplyPagingDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBService {

    /**
     * api명 : {post_idx} 포스팅 댓글 보기
     */
    @GET("v3/campus_talk/posting/{post_idx}/reply")
    fun getAllReply(
        @Header("X-Token") token: String,
        @Path("post_idx") postIdx: Long,
        @Query("page") page: Int,
        @Query("count") count: Int
    ): Single<PostingReplyPagingDto>

    @GET("movie/popular")
    fun popularMovieRx(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int,
        @Query("language") language: String
    ) : Single<MoviesResponse>

    companion object {
        private const val CAMPUSTALK_URL = "http://52.79.106.253:8080/api/"

        fun create(): TMDBService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(CAMPUSTALK_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(TMDBService::class.java)
        }
    }
}