package com.siddhesh.yepl.models

import com.google.gson.annotations.SerializedName
import com.siddhesh.yepl.utils.Keys

data class ErrorModel(
    @SerializedName(Keys.KEY_CODE)
    val code: String? = null,
    @SerializedName(Keys.KEY_DESCRIPTION)
    val description: String? = null
)