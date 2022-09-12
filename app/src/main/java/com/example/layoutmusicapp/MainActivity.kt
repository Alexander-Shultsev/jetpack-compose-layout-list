package com.example.layoutmusicapp

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.layoutmusicapp.ui.screen.MainScreen
import com.example.layoutmusicapp.ui.theme.LayoutMusicAppTheme
import net.openid.appauth.*
import java.security.Permission


@SuppressLint("StaticFieldLeak")
lateinit var activity: Activity
@SuppressLint("StaticFieldLeak")
lateinit var context: Context

class MainActivity : ComponentActivity() {

    private var contentHasLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        activity = this
        context = applicationContext

        // Setting splash screen
//        setupSplashScreen(splashScreen)

        setContent {
            LayoutMusicAppTheme {

                //https://www.raywenderlich.com/32555180-splash-screen-tutorial-for-android

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }


    }

    object AuthConfig {
        const val AUTH_URI = "https://github.com/login/oauth/authorize"
        const val TOKEN_URI = "https://github.com/login/oauth/access_token"
        const val END_SESSION_URL = "https://github.com/logout"
        const val RESPONSE_TYPE = ResponseTypeValues.CODE
        const val CLIENT_ID = "..."
        const val SCOPE = "user,repo"
        const val CLIENT_SECRET = "..."
        const val CALLBACK_URL = "ru.kts.oauth://github.com/callback"
        const val LOGOUT_CALLBACK_URL = "ru.kts.oauth://github.com/logout_callback"
    }

    private val authorizationService: AuthorizationService = AuthorizationService(context)

    private val serviceConfiguration = AuthorizationServiceConfiguration(
        AuthConfig.AUTH_URI.toUri(),
        AuthConfig.TOKEN_URI.toUri(),
        null,
        AuthConfig.CALLBACK_URL.toUri(),
    )

    fun getAuthRequest() : AuthorizationRequest {
        val callbackUri = AuthConfig.CALLBACK_URL.toUri()

        return AuthorizationRequest.Builder(
            serviceConfiguration,
            AuthConfig.CLIENT_ID,
            AuthConfig.RESPONSE_TYPE,
            callbackUri
        ).setScope(AuthConfig.SCOPE).build()
    }

    fun createIntent() {
        val customTabsIntent = CustomTabsIntent.Builder().build()

        val openValuePageIntent = authorizationService.getAuthorizationRequestIntent(
            getAuthRequest(),
            customTabsIntent
        )

        val getAuthResponse = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val dataIntent = it.data ?: return@registerForActivityResult
//            handleA(dataIntent)
        }

        getAuthResponse.launch(openValuePageIntent)
    }

    fun onClear() {
        authorizationService.dispose()
    }

    private fun handleAuthResponseIntent(intent: Intent?) {
        val exception = AuthorizationException.fromIntent(intent)

//        val tokenExchangeRequest = AuthorizationResponse.fromIntent(intent)
//            ?.createTokenExchangeRequest()
//        when {
//            exception != null ->
//        }
    }

// Setting splash screen
//    private fun setupSplashScreen(splashScreen: SplashScreen) {
//        val content: View = findViewById(android.R.id.content)
//        content.viewTreeObserver.addOnPreDrawListener (
//            object : ViewTreeObserver.OnPreDrawListener {
//                override fun onPreDraw() : Boolean {
//                    return if (contentHasLoaded) {
//                        content.viewTreeObserver.removeOnPreDrawListener(this)
//                        true
//                    } else false
//                }
//            }
//        )
//    }
}
