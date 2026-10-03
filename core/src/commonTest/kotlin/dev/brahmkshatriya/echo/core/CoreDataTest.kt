package dev.brahmkshatriya.echo.core

import dev.brahmkshatriya.echo.core.network.HttpRetryInterceptor
import kotlin.test.Test
import kotlin.test.assertNotNull

class CoreDataTest {

    @Test
    fun testHttpRetryInterceptorCreation() {
        val interceptor = HttpRetryInterceptor(maxRetries = 3, baseDelayMs = 500L)
        assertNotNull(interceptor)
    }
}
