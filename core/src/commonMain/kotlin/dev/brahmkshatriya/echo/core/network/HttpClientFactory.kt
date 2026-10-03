package dev.brahmkshatriya.echo.core.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Factory for resilient HTTP clients equipped with exponential backoff and rate-limit handling.
 */
object HttpClientFactory {
    fun createClient(configure: (OkHttpClient.Builder.() -> Unit)? = null): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpRetryInterceptor())

        configure?.invoke(builder)
        return builder.build()
    }
}
