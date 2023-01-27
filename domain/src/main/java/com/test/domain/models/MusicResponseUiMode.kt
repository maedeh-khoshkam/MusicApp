package com.test.domain.models

sealed class MusicResponseUiMode() : UiAwareModel() {
    object Loading : MusicResponseUiMode()
    data class Success(val data: MusicResponse) : MusicResponseUiMode()
    data class Error(var error: String) : MusicResponseUiMode()
}
