package org.sopt.and4ever.presentation.main

import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.sopt.and4ever.BuildConfig
import org.sopt.and4ever.core.theme.JPTheme
import org.sopt.and4ever.data.service.MyPingDetailService
import org.sopt.and4ever.data.service.MyPingService
import org.sopt.and4ever.data.service.OtherPingService
import org.sopt.and4ever.data.service.PingService
import retrofit2.Retrofit


class MainActivity : ComponentActivity() {


    val json = Json {
        coerceInputValues = true
        isLenient = true
    }


    private val client by lazy {
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            },
        ).addInterceptor(Interceptor {
            val request = it.request().newBuilder()
                .addHeader("Authorization", Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID))
                .build()
            it.proceed(request)
        }).build()
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .client(client).build()
    }

    inline fun <reified T> create(): T = retrofit.create(T::class.java)

    val myPingService = create<MyPingService>()
    val otherPingService = create<OtherPingService>()
    val pingService = create<PingService>()
    val myPingDetailService = create<MyPingDetailService>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JPTheme {
                JPNavigation(
                    myPingService = myPingService,
                    myPingDetailService = myPingDetailService,
                    pingService = pingService,
                    otherPingService = otherPingService,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
