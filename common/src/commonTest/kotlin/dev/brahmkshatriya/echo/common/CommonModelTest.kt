package dev.brahmkshatriya.echo.common

import dev.brahmkshatriya.echo.common.models.Date
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class CommonModelTest {

    @Test
    fun testDateCreationAndYear() {
        val date = Date(year = 2026, month = 5, day = 15)
        assertEquals(2026, date.year)
        assertEquals(5, date.month)
        assertEquals(15, date.day)
        assertNotNull(date.date)
    }

    @Test
    fun testEpochDateComparison() {
        val date1 = Date(epochTimeMs = 1000000L)
        val date2 = Date(epochTimeMs = 2000000L)
        assertEquals(true, date1 < date2)
    }
}
