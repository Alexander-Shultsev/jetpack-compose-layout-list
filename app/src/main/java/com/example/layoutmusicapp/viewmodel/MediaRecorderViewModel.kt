package com.example.layoutmusicapp.viewmodel

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.ContentValues.TAG
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.media.MediaRecorder.OutputFormat.MPEG_2_TS
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.layoutmusicapp.activity
import com.example.layoutmusicapp.context
import java.io.File

class MediaRecorderViewModel: ViewModel() {

    private val _recorderStatus: MutableLiveData<String> = MutableLiveData()
    val recorderStatus: LiveData<String> = _recorderStatus

    fun setRecorderStatus(value: String) {
        _recorderStatus.postValue(value)
    }

    private val _buttonStartText: MutableLiveData<String> = MutableLiveData()
    val buttonStartText: LiveData<String> = _buttonStartText

    fun setButtonStartText(value: String) {
        _buttonStartText.postValue(value)
    }

    private var mediaRecorder: MediaRecorder? = null
    private lateinit var permission: Array<String>
    private var outputFile: String
    private var isStared: Boolean = false
    private var isPaused: Boolean = false

    init {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO)
            != PackageManager.PERMISSION_GRANTED
        ) {
            permission = arrayOf(Manifest.permission.RECORD_AUDIO)
            ActivityCompat.requestPermissions(activity, permission, 0)
        }


        outputFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
            .absolutePath + "/record.mp3"

        mediaRecorder = MediaRecorder()
        mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        mediaRecorder?.setOutputFile(outputFile)
        mediaRecorder?.prepare()

    }

    fun changeRecorderStatus() {
        Log.i(TAG, "isStared: $isStared")
        Log.i(TAG, "isPaused: $isPaused")

        if (isStared) {
            if (isPaused) { resume() }
            else {
                pause()
            }
        } else {
            mediaRecorder?.start()
            isStared = true
            setRecorderStatus("Запись идет")
            setButtonStartText("Пауза")
        }
    }

    @SuppressLint("NewApi")
    fun pause() {
        mediaRecorder?.pause()
        isPaused = true
        setRecorderStatus("На паузе")
        setButtonStartText("Возобновить")
    }

    @SuppressLint("NewApi")
    fun resume() {
        mediaRecorder?.resume()
        isPaused = false
        setRecorderStatus("Запись продолжает идти")
        setButtonStartText("Пауза")
    }

    fun stop() {
        mediaRecorder?.stop()
        mediaRecorder?.release()
        isStared = false
        setRecorderStatus("Диктофон")
        setButtonStartText("Старт")
    }



}