package com.example.layoutmusicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.layoutmusicapp.ui.component.BottomNavigation
import com.example.layoutmusicapp.ui.screen.MainScreen
import com.example.layoutmusicapp.ui.theme.LayoutMusicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutMusicAppTheme {

                //https://www.raywenderlich.com/32555180-splash-screen-tutorial-for-android

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    AddSongsScreen()
//                    AlertDialogScreen()
//                    BottomNavigation()
                    MainScreen()
                }
            }
        }
    }
}