package com.test.data.source

import com.test.data.models.MusicParamsEntity
import com.test.data.models.MusicResponseEntity
import com.test.data.repository.MusicCache
import com.test.data.repository.MusicDataSource
import javax.inject.Inject

class MusicCacheDataSource @Inject constructor(private val cache: MusicCache) : MusicDataSource {


    override suspend fun getMusicList(params: MusicParamsEntity): MusicResponseEntity {
        return cache.getMusicList(params)
    }
}