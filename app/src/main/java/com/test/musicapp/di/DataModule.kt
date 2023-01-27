package com.test.musicapp.di

import com.test.data.MusicRepositoryImpl
import com.test.domain.repository.MusicRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {


    @Singleton
    @Provides
    fun provideMusicRepository(musicRepositoryImpl: MusicRepositoryImpl): MusicRepository =
        musicRepositoryImpl
}