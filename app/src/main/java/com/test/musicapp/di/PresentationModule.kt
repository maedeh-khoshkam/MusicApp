package com.test.musicapp.di

import com.test.presentation.utils.CoroutineContextProvider
import com.test.presentation.utils.CoroutineContextProviderImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {


    @Singleton
    @Provides
    fun provideCoroutineContextProvider(coroutineContextProviderImp: CoroutineContextProviderImp): CoroutineContextProvider =
        coroutineContextProviderImp
}