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
    var ratingCount = MutableLiveData<String>(searchBusinessModel.rating.toString())
    var reviewCount = MutableLiveData<String>("("+searchBusinessModel.reviewCount.toString()+")")
    var address = MutableLiveData<String>(
        searchBusinessModel.location!!.displayAddress.toString().replace("[", "").replace("]", "")
    )
    var isClosed = MutableLiveData<Boolean>(searchBusinessModel.isClosed)
    var price = MutableLiveData<String>().apply {
        value = if (!TextUtils.isEmpty(searchBusinessModel.price)) {
            " ${searchBusinessModel.price} "
        } else {
            ""
        }
    }
    var distance = MutableLiveData<String>().apply {
        value = if (searchBusinessModel.distance!! <= 1000) {
            String.format("%.2f Meter.", searchBusinessModel.distance)
        } else {
            String.format("%.2f KM.", searchBusinessModel.distance / 1000)
        }
    }


}