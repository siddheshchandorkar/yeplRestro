package com.siddhesh.yepl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var searchText= MutableLiveData<String>()

}