package com.test.data

import com.test.data.mapper.mapFromEntity
import com.test.data.mapper.mapToEntity
import com.test.data.source.MusicDataSourceFactory
import com.test.domain.models.MusicParams
import com.test.domain.models.MusicResponse
import com.test.domain.repository.MusicRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(private val musicDataSourceFactory: MusicDataSourceFactory) :
    MusicRepository {


    override suspend fun getMusicList(params: MusicParams): Flow<MusicResponse> = flow {
        val isCache = false
        val musicResponse =
            musicDataSourceFactory.getDataStore(isCache).getMusicList(params.mapToEntity())
                .mapFromEntity()
        emit(musicResponse)
    }
}


