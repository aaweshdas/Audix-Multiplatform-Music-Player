package dev.brahmkshatriya.echo

import dev.brahmkshatriya.echo.playback.PlayerState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class PlayerViewModelTest {

    @Test
    fun testPlayerStateRadioStates() {
        val empty = PlayerState.Radio.Empty
        val loading = PlayerState.Radio.Loading
        assertNotNull(empty)
        assertNotNull(loading)
        assertEquals(false, empty == loading)
    }
}
