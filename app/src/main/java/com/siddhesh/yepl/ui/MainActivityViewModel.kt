package com.siddhesh.yepl.ui

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.siddhesh.yepl.models.SearchModel
import com.siddhesh.yepl.network.ApiClient
import com.siddhesh.yepl.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
    var offset = MutableLiveData(0)
    var limit = MutableLiveData(20)
    var radius = MutableLiveData(100)
    var radiusSelected = MutableLiveData("100 M")
    var searchText = MutableLiveData<String>()
    var isRefreshing = MutableLiveData(false)
    var reachMax = MutableLiveData(false)
    var showToast = MutableLiveData<String>()
    var rowItemViewModelAl = ArrayList<RowItemViewModel>()
    var restaurantListAdapter = RestaurantListAdapter(rowItemViewModelAl)


    init {
        searchText.value = "NYC"
        reset()
        callSearchApi(searchText.value!!, offset.value!!)
    }

    var onRefreshListener: SwipeRefreshLayout.OnRefreshListener =
        SwipeRefreshLayout.OnRefreshListener {
            reset()
            callSearchApi(searchText.value!!, offset.value!!)
        }

    var textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            if (!TextUtils.isEmpty(s.toString())) {
                reset()
                if (s.toString().length > 2) {
                    callSearchApi(s.toString(), offset.value!!)
                } else {
                    isRefreshing.value = false
                }
            } else {
                reset()
                isRefreshing.value = false
            }
        }

    }

    fun reset() {
        reachMax.value = false
        isRefreshing.value = true
        offset.value = 0
        rowItemViewModelAl.clear()
        restaurantListAdapter.setData(rowItemViewModelAl)
    }

    fun callSearchApi(locationName: String, offSetValue: Int) {
        if (!reachMax.value!!) {
            val apiServices = ApiClient.client.create(ApiInterface::class.java)
            val call =
                apiServices.getRestaurants(
                    "restaurants",
                    locationName,
                    radius.value!!,
                    "distance",
                    limit.value!!,
                    offSetValue
                )
            call.enqueue(object : Callback<SearchModel> {
                override fun onResponse(call: Call<SearchModel>, response: Response<SearchModel>) {

                    response.body()?.let { searchModel ->
                        searchModel.error?.let {
                            showToast.value = it.description
                            reset()
                            return
                        }

                        searchModel.businesses?.let { list ->
                            list.forEach { searchBusinessModel ->
                                rowItemViewModelAl.add(RowItemViewModel(searchBusinessModel))
                                restaurantListAdapter.setData(rowItemViewModelAl)
                            }
                            if (offset.value!! < searchModel.total!!) {
                                offset.value = +limit.value!!
                            } else {
                                reachMax.value = true
                            }
                            if (rowItemViewModelAl.isNotEmpty()) {
                                showToast.value = "Restaurants Found"
                            } else {
                                showToast.value = "No Restaurants Found"
                            }
                        } ?: {
                            showToast.value = "No Restaurants Found"
                        }
                    }

                    Log.d("MainActivityViewModel", "onResponse: " + offset.value)
                    isRefreshing.value = false
                }

                override fun onFailure(call: Call<SearchModel>, t: Throwable) {
                    Log.d("MainActivityViewModel", "onFailure: ")
                    isRefreshing.value = false
                    showToast.value = "Reached Max Results"

                }

            })

        } else {
            reachMax.value = true
            showToast.value = "Reached Max Results"
        }

    }
}