package com.test.data.source

import com.test.data.models.MusicParamsEntity
import com.test.data.models.MusicResponseEntity
import com.test.data.repository.MusicDataSource
import com.test.data.repository.MusicRemote

class MusicRemoteDataSource(private var remote: MusicRemote) : MusicDataSource {

    override suspend fun getMusicList(params: MusicParamsEntity): MusicResponseEntity {
        return remote.getMusicList(params)
    }
}