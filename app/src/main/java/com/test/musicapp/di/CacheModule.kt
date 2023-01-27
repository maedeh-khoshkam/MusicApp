package com.test.musicapp.di

import com.test.cache.MusicCacheImpl
import com.test.data.repository.MusicCache
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideMusicCache(movieCacheImpl: MusicCacheImpl): MusicCache = movieCacheImpl

}