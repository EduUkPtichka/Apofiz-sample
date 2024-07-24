package com.determent.apofiz_sample.android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.determent.apofiz_sample.android.feature_home.data.remote.FakeStoreApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var retrofitBaseFakeStoreApi: FakeStoreApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configureBaseFakeStoreApi()

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

        val okHttpClientBaseFakeStoreApi = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com")
            .client(okHttpClientBaseFakeStoreApi)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitBaseFakeStoreApi = retrofit.create(FakeStoreApi::class.java)
    }
}