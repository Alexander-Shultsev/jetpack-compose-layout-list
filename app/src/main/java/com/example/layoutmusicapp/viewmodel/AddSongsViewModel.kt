package com.example.layoutmusicapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddSongsViewModel: ViewModel() {

    val tabElem = listOf("Resent", "Local", "Favorite")

    private val _selectedTab: MutableLiveData<Int> = MutableLiveData(0)
    val selectedTab: LiveData<Int> = _selectedTab

    fun changeSelectedTab(selectedTab: Int) {
        _selectedTab.postValue(selectedTab)
    }

}