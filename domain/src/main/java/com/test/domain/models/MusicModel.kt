package com.test.domain.models

data class MusicModel(
    var releaseDate: String? = null,
    var artworkUrl30: String? = null,
    var artworkUrl60: String? = null,
    var artworkUrl100: String? = null,
    var trackName: String? = null,
    var trackId: Int? = null,
    var artistName: String? = null,
    var isStreamable: Boolean? = null,
    var country: String? = null,
    var trackPrice: Double? = null,
    var currency: String? = null,
    var primaryGenreName: String? = null,
    var collectionName: String? = null,
    var collectionCensoredName: String? = null
)
