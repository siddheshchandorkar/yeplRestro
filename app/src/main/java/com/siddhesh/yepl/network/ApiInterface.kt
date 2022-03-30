package com.siddhesh.yepl.network

import androidx.annotation.Nullable
import com.siddhesh.yepl.models.SearchModel
import com.siddhesh.yepl.utils.Keys
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("v3/businesses/search")
    fun getRestaurants(
        @Query(Keys.KEY_TERM) term: String,
        @Query(Keys.KEY_LOCATION) location: String,
        @Query(Keys.KEY_RADIUS) radius: Int,
        @Query(Keys.KEY_SORT_BY) sortBy: String,
        @Query(Keys.KEY_LIMIT) limit: Int,
        @Query(Keys.KEY_OFFSET) offset: Int
    ): Call<SearchModel>

    @GET("v3/businesses/search")
    fun getRestaurantsByLatLong(
        @Query(Keys.KEY_TERM) term: String,
        @Nullable @Query(Keys.KEY_LOCATION) location: String,
        @Query(Keys.KEY_RADIUS) radius: Int,
        @Query(Keys.KEY_SORT_BY) sortBy: String,
        @Query(Keys.KEY_LIMIT) limit: Int
    ): Call<SearchModel>

}