package com.test.presentation.viewModel

import androidx.lifecycle.LiveData
import com.test.domain.interactor.GetMusicListUseCase
import com.test.domain.models.MusicParams
import com.test.domain.models.MusicResponseUiMode
import com.test.presentation.utils.CoroutineContextProvider
import com.test.presentation.utils.UiAwareLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import javax.inject.Inject


@HiltViewModel
class MusicSearchViewModel @Inject constructor(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val getMusicListUseCase: GetMusicListUseCase
) : BaseViewModel(coroutineContextProvider) {


    private val _musicList = UiAwareLiveData<MusicResponseUiMode>()
    val musicList: LiveData<MusicResponseUiMode> = _musicList


    override val coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            _musicList.postValue(MusicResponseUiMode.Error(throwable.message ?: "Error"))
        }


    fun getMusicList(params: MusicParams) {
        _musicList.postValue(MusicResponseUiMode.Loading)
        launchCoroutineIO {
            loadMusicList(params)
        }
    }

    private suspend fun loadMusicList(params: MusicParams) {
        getMusicListUseCase(params).collect {
            _musicList.postValue(MusicResponseUiMode.Success(it))
        }
    }

}