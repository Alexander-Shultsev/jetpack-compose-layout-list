package com.example.layoutmusicapp.viewmodel

import androidx.compose.material.FabPosition
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class EasyPayViewModel : ViewModel() {

    data class InfoOnLoginScreenClass (
        val position: Int,
        val title: String,
        val subtitle: String,
    )

    val infoOnLoginScreen = arrayOf(
        InfoOnLoginScreenClass(0, "Easy Online Payment", "Make your payment experience more better today. No additional admin fee"),
        InfoOnLoginScreenClass(1, "Easy Online", "No additional admin fee"),
        InfoOnLoginScreenClass(2, "Easy Payment", "Make your payment experience more better today"),
    )

    private val _loginCurrentIndicator: MutableLiveData<Int> = MutableLiveData()
    val loginCurrentIndicator: LiveData<Int> = _loginCurrentIndicator

    fun setLoginCurrentIndicator(currentIndicator: Int) {
        _loginCurrentIndicator.postValue(currentIndicator)
    }

}