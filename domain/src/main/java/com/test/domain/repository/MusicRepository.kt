package com.test.domain.repository

import com.test.domain.models.MusicParams
import com.test.domain.models.MusicResponse
import kotlinx.coroutines.flow.Flow

interface MusicRepository {


    // Remote and cache
    suspend fun getMusicList(params: MusicParams): Flow<MusicResponse>
}