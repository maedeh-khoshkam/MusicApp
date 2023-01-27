package com.test.data.repository

import com.test.data.models.MusicParamsEntity
import com.test.data.models.MusicResponseEntity

interface MusicRemote {

    suspend fun getMusicList(params: MusicParamsEntity): MusicResponseEntity
}