package com.test.domain.interactor

import com.test.domain.models.MusicParams
import com.test.domain.models.MusicResponse
import com.test.domain.repository.MusicRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMusicListUseCase @Inject constructor(private val musicRepository: MusicRepository) :
    BaseUseCase<MusicParams, Flow<MusicResponse>> {

    override suspend fun invoke(params: MusicParams): Flow<MusicResponse> =
        musicRepository.getMusicList(params)

}