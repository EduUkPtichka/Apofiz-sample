package com.determent.apofiz_sample.android.feature_home.data.model

import java.math.BigDecimal

data class FakeStoreModel(
    val id: Int,
    val title: String,
    val price: BigDecimal,
    val description: String,
    val image: String,
    val rating: Rating
) {
    data class Rating(
        val rate: Double,
        val count: Int
    )
}