package com.example.layoutmusicapp.ui.screen

import android.media.MediaRecorder
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import com.example.layoutmusicapp.viewmodel.MediaRecorderViewModel

@Composable
fun MediaRecorderScreen(mediaRecorderViewModel: MediaRecorderViewModel = MediaRecorderViewModel()) {
    val pauseButtonText = rememberSaveable { mutableStateOf("Пауза") }

    mediaRecorderViewModel.start()

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Диктофон")
        Button(
            onClick = { },
            content = { Text("Запуск") }
        )
        Button(
            onClick = { },
            content = { Text(pauseButtonText.value) }
        )
        Button(
            onClick = { },
            content = { Text("Стоп") }
        )
    }
}