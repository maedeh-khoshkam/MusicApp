package com.test.musicapp.di

import com.test.data.repository.MusicRemote
import com.test.musicapp.BuildConfig
import com.test.remote.MusicRemoteImpl
import com.test.remote.api.MusicService
import com.test.remote.api.ServiceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {


    @Singleton
    @Provides
    fun provideMusicService(): MusicService =
        ServiceFactory.create(BuildConfig.DEBUG, BuildConfig.BASE_URL)

    @Singleton
    @Provides
    fun provideMusicRemote(movieRemoteImpl: MusicRemoteImpl): MusicRemote = movieRemoteImpl
}