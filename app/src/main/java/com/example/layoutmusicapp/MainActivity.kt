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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.layoutmusicapp.ui.screen.MainScreen
import com.example.layoutmusicapp.ui.theme.LayoutMusicAppTheme
import org.jetbrains.hub.oauth2.client.jersey.oauth2Client
import java.net.URI
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

    // https://www.youtube.com/watch?v=PFZ3cwxn9Wk

    private object AppConfig {
        const val AUTH_URI = "https://github.com/login/oauth/access_token"
        const val TOKEN_URI = "https://github.com/login/oauth/access_token"
        const val CLIENT_ID = ""
        const val _ID = ""
        const val TYPE = ""
        const val SOURCE = "user,repo"

        const val REDIRECT_URI = ""
        const val REDIRECT_URI2 = ""
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
