package com.test.cache

import com.test.data.models.MusicParamsEntity
import com.test.data.models.MusicResponseEntity
import com.test.data.repository.MusicCache
import javax.inject.Inject

class MusicCacheImpl @Inject constructor():MusicCache {
    override suspend fun getMusicList(params: MusicParamsEntity): MusicResponseEntity {
        TODO("Not yet implemented")
    }
}