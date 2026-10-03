package dev.brahmkshatriya.echo.core.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import kotlin.random.Random

/**
 * Exponential backoff interceptor for network calls (e.g. YouTube API / InnerTube).
 * Retries on HTTP 429 (Rate Limit) and server errors (500, 502, 503, 504)
 * with delays: 1s, 2s, 4s, 8s + randomized jitter.
 */
class HttpRetryInterceptor(
    private val maxRetries: Int = 4,
    private val baseDelayMs: Long = 1000L
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var response: Response? = null
        var lastException: IOException? = null
        var retryCount = 0

        while (retryCount <= maxRetries) {
            try {
                response?.close()
                response = chain.proceed(request)
                
                // Success or non-retryable client error
                if (response.isSuccessful || (response.code != 429 && response.code !in 500..504)) {
                    return response
                }
            } catch (e: IOException) {
                lastException = e
            }

            if (retryCount >= maxRetries) {
                break
            }

            // Exponential backoff: 1s, 2s, 4s, 8s + jitter (0-500ms)
            val backoffMs = (baseDelayMs * (1L shl retryCount)) + Random.nextLong(0, 500)
            try {
                Thread.sleep(backoffMs)
            } catch (_: InterruptedException) {
                Thread.currentThread().interrupt()
                break
            }

            retryCount++
        }

        return response ?: throw (lastException ?: IOException("Request failed after $maxRetries retries"))
    }
}
