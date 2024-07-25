package com.determent.apofiz_sample.common.feature_star_wars.core.network

import okhttp3.OkHttpClient

/**
 * Единая точка для настройки единственного Connection pool
 */
object EngineOkHttpClient {

    val okHttpClient = OkHttpClient.Builder()

        .build()
}
