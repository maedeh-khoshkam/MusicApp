package com.test.data.models


data class MusicResponseEntity(
    var resultCount: Int? = null,
    var results: List<MusicEntity> = arrayListOf()
)
