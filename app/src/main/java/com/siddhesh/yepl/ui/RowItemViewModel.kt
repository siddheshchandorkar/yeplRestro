package com.siddhesh.yepl.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siddhesh.yepl.models.SearchBusinessModel

class RowItemViewModel(searchBusinessModel: SearchBusinessModel) : ViewModel() {
    var photoUrl = MutableLiveData<String>(searchBusinessModel.imageUrl)
    var title = MutableLiveData<String>(searchBusinessModel.name)
    var transactions = MutableLiveData<String>()
    var rating = MutableLiveData<Float>(searchBusinessModel.rating)


}