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
    val imageUrl: String? = null,
    @SerializedName(Keys.KEY_IS_CLOSED)
    val isClosed: Boolean = false,
    @SerializedName(Keys.KEY_URL)
    val url: String? = null,
    @SerializedName(Keys.KEY_REVIEW_COUNT)
    val reviewCount: Long? = null,
    @SerializedName(Keys.KEY_CATEGORIES)
    val categories: ArrayList<CategoryModel>? = null,
    @SerializedName(Keys.KEY_RATING)
    val rating: Float? = null,
    @SerializedName(Keys.KEY_COORDINATES)
    val coordinates: CoordinateModel? = null,
    @SerializedName(Keys.KEY_TRANSACTIONS)
    val transactions: ArrayList<String>? = null,
    @SerializedName(Keys.KEY_PRICE)
    val price: String? = null,
    @SerializedName(Keys.KEY_LOCATION)
    val location: LocationModel? = null,
    @SerializedName(Keys.KEY_PHONE)
    val phone: String? = null,
    @SerializedName(Keys.KEY_DISPLAY_PHONE)
    val displayPhone: String? = null,
    @SerializedName(Keys.KEY_DISTANCE)
    val distance: Double? = null
)