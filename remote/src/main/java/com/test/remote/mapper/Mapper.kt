package com.test.remote.mapper

import com.test.data.models.MusicEntity
import com.test.data.models.MusicResponseEntity
import com.test.remote.modes.MusicModel
import com.test.remote.modes.MusicResponseModel


fun MusicResponseModel.mapFromRemoteModel(): MusicResponseEntity {
    return MusicResponseEntity(resultCount, results.mapFromRemoteModel())
}


fun ArrayList<MusicModel>.mapFromRemoteModel(): List<MusicEntity> {
    return map {
        val item = MusicEntity(
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