package com.siddhesh.yepl.models

import com.google.gson.annotations.SerializedName
import com.siddhesh.yepl.utils.Keys

data class SearchModel(
    @SerializedName(Keys.KEY_BUSINESSES)
    val businesses: ArrayList<SearchBusinessModel>? = null,
    @SerializedName(Keys.KEY_TOTAL)
    val total: Long? = null
)