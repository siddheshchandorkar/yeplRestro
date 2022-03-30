package com.siddhesh.yepl.models

import com.google.gson.annotations.SerializedName
import com.siddhesh.yepl.utils.Keys

data class LocationModel(
    @SerializedName(Keys.KEY_ADDRESS1)
    val address1: String? = null,
    @SerializedName(Keys.KEY_ADDRESS2)
    val address2: String? = null,
    @SerializedName(Keys.KEY_ADDRESS3)
    val address3: String? = null,
    @SerializedName(Keys.KEY_CITY)
    val city: String? = null,
    @SerializedName(Keys.KEY_ZIP_CODE)
    val zipCode: String? = null,
    @SerializedName(Keys.KEY_COUNTRY)
    val country: String? = null,
    @SerializedName(Keys.KEY_STATE)
    val state: String? = null,
    @SerializedName(Keys.KEY_DISPLAY_ADDRESS)
    val displayAddress: ArrayList<String>? = null
)