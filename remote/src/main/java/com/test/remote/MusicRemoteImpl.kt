package com.test.remote

import com.test.data.models.MusicParamsEntity
import com.test.data.models.MusicResponseEntity
import com.test.data.repository.MusicRemote
import com.test.remote.api.MusicService
import com.test.remote.mapper.mapFromRemoteModel
import javax.inject.Inject

class MusicRemoteImpl @Inject constructor(private val musicService: MusicService) : MusicRemote {

    override suspend fun getMusicList(params: MusicParamsEntity): MusicResponseEntity {
        return musicService.getMusicList(params.term, params.country).mapFromRemoteModel()
    }
}


