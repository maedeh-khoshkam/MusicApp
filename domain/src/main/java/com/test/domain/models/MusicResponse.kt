package com.test.domain.models

data class MusicResponse(

    var resultCount: Int? = null,
    var results: List<MusicModel> = arrayListOf()
)



