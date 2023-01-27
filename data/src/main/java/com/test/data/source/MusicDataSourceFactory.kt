package com.test.data.source

import com.test.data.repository.MusicDataSource
import javax.inject.Inject

class MusicDataSourceFactory @Inject constructor(
    private val musicCacheDataSource: MusicCacheDataSource,
    private val musicRemoteDataSource: MusicRemoteDataSource
) {


    fun getDataStore(isCache: Boolean): MusicDataSource {
        return if (isCache) {
            getCacheDataSource()
        } else {
            getRemoteDataSource()
        }
    }


    private fun getCacheDataSource(): MusicDataSource {
        return musicCacheDataSource
    }

    private fun getRemoteDataSource(): MusicDataSource {
        return musicRemoteDataSource
    }


}