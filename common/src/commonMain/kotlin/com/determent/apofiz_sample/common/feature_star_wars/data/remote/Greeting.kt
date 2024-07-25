package com.determent.apofiz_sample.common.feature_star_wars.data.remote

import de.jensklingenberg.ktorfit.converter.CallConverterFactory
import de.jensklingenberg.ktorfit.converter.FlowConverterFactory
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

val ktorfit = ktorfit {
    baseUrl(StarWarsApi.baseUrl)
    httpClient(HttpClient {

    })
    converterFactories(
        FlowConverterFactory(),
        CallConverterFactory()
    )
}

val starWarsApi = ktorfit.createStarWarsApi()

class Greeting {
    fun greeting() {

        loadData()
    }
}

@OptIn(DelicateCoroutinesApi::class)
fun loadData() {
    GlobalScope.launch {
        val response = starWarsApi.getPersonByIdResponse(3)
    }
}

