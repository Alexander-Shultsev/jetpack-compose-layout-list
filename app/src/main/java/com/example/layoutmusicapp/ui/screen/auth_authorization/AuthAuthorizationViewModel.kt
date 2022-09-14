package com.example.layoutmusicapp.ui.screen.auth_authorization

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.layoutmusicapp.model.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import net.openid.appauth.TokenRequest

class AuthAuthorizationViewModel: ViewModel() {

    private val loadingMutableStateLaunch = MutableStateFlow(false)
    private val repository = AuthRepository()

    fun onExchangeRequest(tokenExchangeIntent: TokenRequest) {
        Log.i(ContentValues.TAG, "код получен: ${tokenExchangeIntent.authorizationCode}")

        viewModelScope.launch {
            loadingMutableStateLaunch.value = true
            kotlin.runCatching {
                repository.
            }.onSuccess {

            }.onFailure {

            }

        }
    }

}