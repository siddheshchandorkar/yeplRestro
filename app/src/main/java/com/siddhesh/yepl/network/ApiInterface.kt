package com.siddhesh.yepl.network

import com.siddhesh.yepl.models.SearchModel
import com.siddhesh.yepl.utils.Keys
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET("v3/businesses/search")
    fun getRestaurants(
        @Query(Keys.KEY_TERM) term: String,
        @Query(Keys.KEY_LOCATION) location: String,
        @Query(Keys.KEY_LIMIT) limit: String,
        @Query(Keys.KEY_RADIUS) radius: String,
        @Query(Keys.KEY_SORT_BY) sortBy: String,
    ): Call<SearchModel>

}