package com.example.layoutmusicapp.model

import com.example.layoutmusicapp.model.models.TokenStorage
import net.openid.appauth.AuthorizationRequest
import net.openid.appauth.AuthorizationService
import net.openid.appauth.TokenRequest

class AuthRepository {

    fun getAuthRequest(): AuthorizationRequest {
        return AppAuth.getAuthorizationRequest()
    }

    suspend fun performTokenRequest(
        authService: AuthorizationService,
        tokenRequest: TokenRequest
    ) {
        val token = AppAuth.performTokenRequestSuspend(authService, tokenRequest)

        TokenStorage.idToken = token.idToken
        TokenStorage.accessToken = token.accessToken
        TokenStorage.refreshToken = token.refreshToken
    }

}