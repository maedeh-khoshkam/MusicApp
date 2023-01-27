package com.test.remote.modes

import com.google.gson.annotations.SerializedName

data class MusicModel(
    @SerializedName("releaseDate")
    var releaseDate: String? = null,
    @SerializedName("artworkUrl30")
    var artworkUrl30: String? = null,
    @SerializedName("artworkUrl60")
    var artworkUrl60: String? = null,
    @SerializedName("artworkUrl100")
    var artworkUrl100: String? = null,
    @SerializedName("trackName")
    var trackName: String? = null,
    @SerializedName("trackId")
    var trackId: Int? = null,
    @SerializedName("artistName")
    var artistName: String? = null,
    @SerializedName("isStreamable")
    var isStreamable: Boolean? = null,
    @SerializedName("country")
    var country: String? = null,
    @SerializedName("trackPrice")
    var trackPrice: Double? = null,
    @SerializedName("currency")
    var currency: String? = null,
    @SerializedName("primaryGenreName")
    var primaryGenreName: String? = null,
    @SerializedName("collectionName")
    var collectionName: String? = null,
    @SerializedName("collectionCensoredName")
    var collectionCensoredName: String? = null
)
