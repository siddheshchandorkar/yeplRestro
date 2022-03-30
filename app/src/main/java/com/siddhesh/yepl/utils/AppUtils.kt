package com.siddhesh.yepl.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class AppUtils {


    fun isNetworkAvailable(context:Context): Boolean {

        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetworkInfo: NetworkInfo? = null
        activeNetworkInfo = cm.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }
}