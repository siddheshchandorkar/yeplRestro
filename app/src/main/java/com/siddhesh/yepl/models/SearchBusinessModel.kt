package com.siddhesh.yepl.models

import com.google.gson.annotations.SerializedName
import com.siddhesh.yepl.utils.Keys

data class SearchBusinessModel(
    @SerializedName(Keys.KEY_ID)
    val id: String? = null,
    @SerializedName(Keys.KEY_ALIAS)
    val alias: String? = null,
    @SerializedName(Keys.KEY_NAME)
    val name: String? = null,
    @SerializedName(Keys.KEY_IMAGE_URL)
    val imageUrl: String? = null
)