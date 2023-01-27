package com.test.remote.api

import com.test.remote.modes.MusicResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicService {


    @GET("search?")
    suspend fun getMusicList(
        @Query("term") term: String,
        @Query("country") country: String
    ): MusicResponseModel

}