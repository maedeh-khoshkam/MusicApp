package com.test.presentation.fakes

import com.test.domain.models.MusicModel
import com.test.domain.models.MusicResponse

object FakePresentationData {


    private fun getMusicResponse(): MusicResponse {
        return MusicResponse(20, getMusicList())
    }

    private fun getMusicList(): List<MusicModel> {
        val list: MutableList<MusicModel> = mutableListOf()
        for (i in 0 until 20) {
            val item = MusicModel(trackName = "Terrier $i", country = "DNK")
        }
        return list
    }

    fun getMusicResponse(term: String, country: String): MusicResponse {
        val response = getMusicResponse()
        val searchList: MutableList<MusicModel> = mutableListOf()
        if (term.isEmpty()) {
            return MusicResponse(0, searchList)
        }
        searchList.addAll(response.results.filter {
            it.country == country && it.trackName?.contains(
                term
            ) == true
        })
        return MusicResponse(searchList.size, searchList)
    }

}