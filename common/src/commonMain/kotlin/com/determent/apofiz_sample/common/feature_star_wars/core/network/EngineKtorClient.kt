package com.determent.apofiz_sample.common.feature_star_wars.core.network

import io.ktor.client.HttpClient

expect object EngineKtorClient {
    val engineKtorClient: HttpClient
}