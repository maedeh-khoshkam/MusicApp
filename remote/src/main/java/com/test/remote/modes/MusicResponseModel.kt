package com.test.remote.modes

import com.google.gson.annotations.SerializedName

data class MusicResponseModel(
    @SerializedName("resultCount")
    var resultCount: Int? = null,
    @SerializedName("results")
    var results: ArrayList<MusicModel> = arrayListOf()
)
