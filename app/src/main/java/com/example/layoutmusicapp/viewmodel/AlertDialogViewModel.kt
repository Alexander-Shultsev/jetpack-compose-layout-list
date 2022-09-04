package com.example.layoutmusicapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.core.view.ContentInfoCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AlertDialogViewModel: ViewModel() {

    private val _showDialog: MutableLiveData<Boolean> = MutableLiveData(false)
    val showDialog: LiveData<Boolean> = _showDialog

    fun changeVisibleDialog() {
        _showDialog.postValue(!showDialog.value!!)
    }


    private val _dialogText: MutableLiveData<String> = MutableLiveData("")
    val dialogText: LiveData<String> = _dialogText

    fun changeDialogText(text: String) {
        _dialogText.postValue(text)
    }

}