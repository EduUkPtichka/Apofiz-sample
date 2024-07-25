package com.determent.apofiz_sample.android

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.determent.apofiz_sample.android.feature_home.data.remote.FakeStoreApi
import com.determent.apofiz_sample.common.feature_star_wars.core.network.EngineKtorClient
import com.determent.apofiz_sample.common.feature_star_wars.core.network.EngineOkHttpClient
import com.determent.apofiz_sample.common.feature_star_wars.data.remote.Greeting
import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var retrofitBaseFakeStoreApi: FakeStoreApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val one1: HttpClient = EngineKtorClient.engineKtorClient

        val one2: HttpClient = EngineKtorClient.engineKtorClient

        configureBaseFakeStoreApi()
        val gretting = Greeting().apply {
            greeting()
        }

        if (one1 === one2) {
            Log.d("actual Expect class singele?", "onCreate: singel ")
        } else {
            Log.d("actual Expect class singele?", "onCreate: no singel ")
        }

        val scope = CoroutineScope(Dispatchers.IO)

        enableEdgeToEdge()

        scope.launch {
            val state = retrofitBaseFakeStoreApi.getFakeStoreById(1)
        }

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun configureBaseFakeStoreApi() {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

//        val okHttpClientBaseFakeStoreApi = OkHttpClient.Builder()
//            .addInterceptor(httpLoggingInterceptor)
//            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com")
            .client(EngineOkHttpClient.okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitBaseFakeStoreApi = retrofit.create(FakeStoreApi::class.java)
    }
}