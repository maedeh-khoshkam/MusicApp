package com.test.musicapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import com.test.musicapp.base.BaseActivity
import com.test.musicapp.databinding.ActivityMusicBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicActivity : BaseActivity<ActivityMusicBinding>() {


    override fun getViewBinding(): ActivityMusicBinding = ActivityMusicBinding.inflate(
        LayoutInflater.from(this)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}