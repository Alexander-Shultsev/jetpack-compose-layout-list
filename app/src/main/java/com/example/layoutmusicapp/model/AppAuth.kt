package com.example.layoutmusicapp.model

import android.net.Uri
import androidx.core.net.toUri
import com.example.layoutmusicapp.model.models.TokensModel
import net.openid.appauth.*
import kotlin.coroutines.suspendCoroutine

object AppAuth {

    private val serviceConfiguration = AuthorizationServiceConfiguration(
        Uri.parse(AuthConfig.AUTH_URI),
        Uri.parse(AuthConfig.TOKEN_URI),
        null,
        Uri.parse(AuthConfig.END_SESSION_URL),
    )

    fun getAuthorizationRequest(): AuthorizationRequest {
        val redirectUri = AuthConfig.CALLBACK_URL.toUri()

        return AuthorizationRequest.Builder (
            serviceConfiguration,
            AuthConfig.CLIENT_ID,
            AuthConfig.TYPE,
            redirectUri
        )
            .setScope(AuthConfig.SCOPE)
            .build()
    }

    suspend fun performTokenRequestSuspend(
        authService: AuthorizationService,
        tokenRequest: TokenRequest,
    ): TokensModel {
        return suspendCoroutine { continuation ->
            authService.performTokenRequest(tokenRequest, getClientAuthentication()) { response, ex ->
                when {
                    response != null -> {
                        //получение токена произошло успешно
                        val tokens = TokensModel(
                            accessToken = response.accessToken.orEmpty(),
                            refreshToken = response.refreshToken.orEmpty(),
                            idToken = response.idToken.orEmpty()
                        )
                        continuation.resumeWith(Result.success(tokens))
                    }
                    //получение токенов произошло неуспешно, показываем ошибку
                    ex != null -> { continuation.resumeWith(Result.failure(ex)) }
                    else -> error("unreachable")
                }
            }
        }
    }

    private fun getClientAuthentication(): ClientAuthentication {
        return ClientSecretPost(AuthConfig.CLIENT_SECRET)
    }

    private object AuthConfig {
        const val AUTH_URI = "https://github.com/login/oauth/access_token"
        const val TOKEN_URI = "https://github.com/login/oauth/access_token"
        const val END_SESSION_URL = "https://github.com/logout"
        const val TYPE = ResponseTypeValues.CODE
        const val SCOPE = "user,repo"

        const val CLIENT_ID = "8f660ae4ad8e68494948"
        const val CLIENT_SECRET = "82d09029a4c49605c22217968a4d669824e44c6c"
        const val CALLBACK_URL = "ru.kts.oauth://github.com/logout"
        const val LOGOUT_CALLBACK_URL = "ru.kts.oauth://github.com/logout_callback"
    }
}