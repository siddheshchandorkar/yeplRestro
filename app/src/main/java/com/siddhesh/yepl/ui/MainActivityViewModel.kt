package com.siddhesh.yepl.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siddhesh.yepl.models.SearchModel
import com.siddhesh.yepl.network.ApiClient
import com.siddhesh.yepl.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
    var searchText = MutableLiveData<String>()

    init {

        val apiServices = ApiClient.client.create(ApiInterface::class.java)
        val call = apiServices.getRestaurants("restaurants", "NYC", 5000, "distance", 15)
        call.enqueue(object : Callback<SearchModel> {
            override fun onResponse(call: Call<SearchModel>, response: Response<SearchModel>) {

                Log.d("MainActivityViewModel", "onResponse: " + response.body())

            }

            override fun onFailure(call: Call<SearchModel>, t: Throwable) {
                Log.d("MainActivityViewModel", "onFailure: " + t.toString())

            }

        })
    }
}