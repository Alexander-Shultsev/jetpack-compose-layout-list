package com.example.layoutmusicapp.viewmodel

import android.Manifest
import android.app.Activity
import android.app.Application
import android.media.MediaRecorder
import android.view.View
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.layoutmusicapp.activity

class MediaRecorderViewModel: ViewModel() {

    private var outputFile: String? = null
    private var mediaRecorder: MediaRecorder? = null
    private var isStared: Boolean? = false
    private var isPaused: Boolean? = false

    init {
        val permission = arrayOf(Manifest.permission.RECORD_AUDIO)
        ActivityCompat.requestPermissions(activity, permission, 13)
    }


    fun start() {
        Toast.makeText(activity, "Ура, получилось", Toast.LENGTH_SHORT).show()
    }

    fun pause() {

    }

    fun stop() {

    }

}