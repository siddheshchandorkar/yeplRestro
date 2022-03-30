package com.siddhesh.yepl.ui

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siddhesh.yepl.models.SearchBusinessModel

class RowItemViewModel(searchBusinessModel: SearchBusinessModel) : ViewModel() {
    var photoUrl = MutableLiveData<String>(searchBusinessModel.imageUrl)
    var title = MutableLiveData<String>(searchBusinessModel.name)
    var transactions = MutableLiveData<String>()
    var rating = MutableLiveData<Float>(searchBusinessModel.rating)
    var reviewCount = MutableLiveData<String>(searchBusinessModel.reviewCount.toString())
    var address = MutableLiveData<String>(
        searchBusinessModel.location!!.displayAddress.toString().replace("[", "").replace("]", "")
    )
    var phone = MutableLiveData<String>(searchBusinessModel.phone)
    var price = MutableLiveData<String>().apply {
        value = if (!TextUtils.isEmpty(searchBusinessModel.price)) {
            "Price : ${searchBusinessModel.price}"
        } else {
            ""
        }
    }
    var distance = MutableLiveData<String>().apply {
        value = if (searchBusinessModel.distance!! <= 1000) {
            String.format("%.2f M", searchBusinessModel.distance)
        } else {
            String.format("%.2f KM", searchBusinessModel.distance / 1000)
        }
    }


}