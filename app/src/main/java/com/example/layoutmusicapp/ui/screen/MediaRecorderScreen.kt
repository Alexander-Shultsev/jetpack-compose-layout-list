package com.example.layoutmusicapp.ui.screen

import android.media.MediaRecorder
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.layoutmusicapp.viewmodel.MediaRecorderViewModel

@Composable
fun MediaRecorderScreen(mediaRecorderViewModel: MediaRecorderViewModel = MediaRecorderViewModel()) {
    val recorderStatus = mediaRecorderViewModel.recorderStatus.observeAsState("Диктофон")
    val buttonStartText = mediaRecorderViewModel.buttonStartText.observeAsState("Начать запись")

    Box(
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = recorderStatus.value)
            Button(
                onClick = { mediaRecorderViewModel.changeRecorderStatus() },
                content = { Text(buttonStartText.value) }
            )
            Button(
                onClick = { mediaRecorderViewModel.stop() },
                content = { Text("Стоп") }
            )
        }
    }
}