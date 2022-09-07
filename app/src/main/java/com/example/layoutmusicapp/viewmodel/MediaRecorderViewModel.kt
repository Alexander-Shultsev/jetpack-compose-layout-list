package com.example.layoutmusicapp.viewmodel

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.ContentValues.TAG
import android.content.Context
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.media.MediaRecorder.OutputFormat.MPEG_2_TS
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
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
import java.security.Permission


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
    private lateinit var outputFile: String
    private var isStared: Boolean = false
    private var isPaused: Boolean = false

    init {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO)
            == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED
        ) {
            runInitialization()
        } else {
            permission = arrayOf(
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)

            ActivityCompat.requestPermissions(activity, permission, 0)
        }
    }

    private fun runInitialization() {
        outputFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            .absolutePath + "/record.mp3"

        mediaRecorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_2_TS)
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            setOutputFile(outputFile)
            prepare()
        }
    }

    fun changeRecorderStatus() {
        Log.i(TAG, "isStared: $isStared")
        Log.i(TAG, "isPaused: $isPaused")

        if (isStared) {
            if (isPaused) {
                resume()
            }
            else {
                pause()
            }
        } else {
            start()
        }
    }

    fun start() {
        mediaRecorder?.start()
        isStared = true
        setRecorderStatus("Запись идет")
        setButtonStartText("Пауза")
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