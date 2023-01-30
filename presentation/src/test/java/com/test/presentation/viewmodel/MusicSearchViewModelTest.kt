package com.test.presentation.viewmodel

import androidx.lifecycle.Observer
import com.test.domain.interactor.GetMusicListUseCase
import com.test.domain.models.MusicParams
import com.test.domain.models.MusicResponseUiMode
import com.test.presentation.fakes.FakePresentationData
import com.test.presentation.utils.PresentationBaseTest
import com.test.presentation.viewModel.MusicSearchViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.io.IOException


@ExperimentalCoroutinesApi
class MusicSearchViewModelTest : PresentationBaseTest() {


    @Mock
    private lateinit var getMusicListUseCase: GetMusicListUseCase

    @Mock
    private lateinit var musicSearchViewModel: MusicSearchViewModel


    @Mock
    private lateinit var observer: Observer<MusicResponseUiMode>

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        musicSearchViewModel = MusicSearchViewModel(dispatcher, getMusicListUseCase)

        musicSearchViewModel.musicList.observeForever(observer)
    }

    @Test
    fun `get music list should return music response from use-case`() {
        dispatcher.test.runBlockingTest {
            // Arrange (Given)
            val term = "Terr"
            val country = "DK"
            val media = "music"
            val musicResponse = FakePresentationData.getMusicResponse(term, country)
            val params = MusicParams(term, country, media)
            whenever(getMusicListUseCase(params)).thenReturn(flowOf(musicResponse))
            // Act (When)
            musicSearchViewModel.getMusicList(params)
            // Assert (Then)
            verify(observer).onChanged(MusicResponseUiMode.Loading)
            verify(observer).onChanged(MusicResponseUiMode.Success(musicResponse))
        }
    }

    @Test
    fun `get music list should return empty music list from use-case`() {
        dispatcher.test.runBlockingTest {
            // Arrange (Given)
            val term = ""
            val country = "DK"
            val media = "music"
            val musicResponse = FakePresentationData.getMusicResponse(term, country)
            val params = MusicParams(term, country, media)
            whenever(getMusicListUseCase(params)).thenReturn(flowOf(musicResponse))
            // Act (When)
            musicSearchViewModel.getMusicList(params)
            // Assert (Then)
            verify(observer).onChanged(MusicResponseUiMode.Loading)
            verify(observer).onChanged(MusicResponseUiMode.Success(musicResponse))
        }
    }

    @Test
    fun `get music list should return error from use-case`() =
        dispatcher.test.runBlockingTest {
            // Arrange (Given)
            val errorMessage = "Internal server error"
            val term = "s"
            val country = "DK"
            val media = "music"
            val params = MusicParams(term, country, media)
            whenever(getMusicListUseCase(params)).thenAnswer {
                throw IOException(errorMessage)
            }

            // Act (When)
            musicSearchViewModel.getMusicList(params)

            // Assert (Then)
            verify(observer).onChanged(MusicResponseUiMode.Loading)
            verify(observer).onChanged(MusicResponseUiMode.Error(errorMessage))
        }


    @After
    fun tearDown() {
        musicSearchViewModel.onCleared()
    }


}