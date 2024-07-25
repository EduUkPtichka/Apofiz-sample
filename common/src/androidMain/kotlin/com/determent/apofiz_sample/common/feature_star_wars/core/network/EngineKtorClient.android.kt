package com.determent.apofiz_sample.common.feature_star_wars.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp

actual val ktorClientEngine: HttpClient
    get() = HttpClient(OkHttp) {
        engine {
            preconfigured = EngineOkHttpClient.okHttpClient
        }
    }
