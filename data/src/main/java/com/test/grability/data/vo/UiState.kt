package com.test.grability.data.vo

sealed class UiState {
    object Loading : UiState()
    object Success: UiState()
    object Error: UiState()
}
