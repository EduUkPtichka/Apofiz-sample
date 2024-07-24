package com.determent.apofiz_sample.android.feature_home.data.remote

import com.determent.apofiz_sample.android.feature_home.data.model.FakeStoreModel
import retrofit2.http.GET
import retrofit2.http.Path

interface FakeStoreApi {
    @GET("products/{id}")
    suspend fun getFakeStoreById(@Path("id") id: Int): FakeStoreModel
}