package com.test.data.mapper

import com.test.data.models.MusicEntity
import com.test.data.models.MusicParamsEntity
import com.test.data.models.MusicResponseEntity
import com.test.domain.models.MusicModel
import com.test.domain.models.MusicParams
import com.test.domain.models.MusicResponse


fun MusicParams.mapToEntity(): MusicParamsEntity {
    return MusicParamsEntity(term, country)
}

fun MusicResponseEntity.mapFromEntity(): MusicResponse {
    return MusicResponse(resultCount, results.mapFromEntity())
}

fun List<MusicEntity>.mapFromEntity(): List<MusicModel> {
    return map {
        val item = MusicModel(
            it.releaseDate,
            it.artworkUrl30,
            it.artworkUrl60,
            it.artworkUrl100,
            it.trackName,
            it.trackId,
            it.artistName,
            it.isStreamable,
            it.country,
            it.trackPrice,
            it.currency,
            it.primaryGenreName,
            it.collectionName,
            it.collectionCensoredName
        )
        item
    }
}