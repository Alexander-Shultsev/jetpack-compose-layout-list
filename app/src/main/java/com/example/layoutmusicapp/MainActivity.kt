package com.example.layoutmusicapp

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Context
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
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.layoutmusicapp.ui.screen.MainScreen
import com.example.layoutmusicapp.ui.theme.LayoutMusicAppTheme
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
