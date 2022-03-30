package com.siddhesh.yepl.models

import com.google.gson.annotations.SerializedName
import com.siddhesh.yepl.utils.Keys

data class CategoryModel(
    @SerializedName(Keys.KEY_ALIAS)
    val alias: String? = null,
    @SerializedName(Keys.KEY_TITLE)
    val title: String? = null
)