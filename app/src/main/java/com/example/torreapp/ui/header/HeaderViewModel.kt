package com.example.torreapp.ui.header

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HeaderViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Header Fragment"
    }
    val text: LiveData<String> = _text
}