package dev.brahmkshatriya.echo.playback

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.PowerManager
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.media3.common.Player
import dev.brahmkshatriya.echo.R
import dev.brahmkshatriya.echo.ui.screensaver.ScreensaverActivity
import dev.brahmkshatriya.echo.utils.ContextUtils.getSettings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LockScreenScreensaverManager(
    private val context: Context,
    private val scope: CoroutineScope,
    private val player: Player
) {
    companion object {
        const val KEY_LOCKSCREEN_SCREENSAVER = "lockscreen_screensaver_enabled"
        const val KEY_SCREENSAVER_DELAY_SEC = "lockscreen_screensaver_delay_sec"
        const val DEFAULT_DELAY_SEC = 7
        private const val CHANNEL_ID = "screensaver_ambient_channel"
        private const val NOTIFICATION_ID = 88991
    }

    private var screensaverJob: Job? = null
    private var isReceiverRegistered = false
    private val powerManager = context.getSystemService(Context.POWER_SERVICE) as? PowerManager
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager

    private val screenReceiver = object : BroadcastReceiver() {
        override fun onReceive(c: Context?, intent: Intent?) {
            when (intent?.action) {
                Intent.ACTION_SCREEN_OFF -> {
                    onScreenTurnedOff()
                }
                Intent.ACTION_SCREEN_ON,
                Intent.ACTION_USER_PRESENT -> {
                    cancelScheduledScreensaver()
                }
            }
        }
    }

    private val playerListener = object : Player.Listener {
        override fun onIsPlayingChanged(isPlaying: Boolean) {
            if (!isPlaying) {
                cancelScheduledScreensaver()
            }
        }
    }

    fun start() {
        createNotificationChannel()
        player.addListener(playerListener)

        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_OFF)
            addAction(Intent.ACTION_SCREEN_ON)
            addAction(Intent.ACTION_USER_PRESENT)
        }
        runCatching {
            ContextCompat.registerReceiver(
                context,
                screenReceiver,
                filter,
                ContextCompat.RECEIVER_NOT_EXPORTED
            )
            isReceiverRegistered = true
        }.onFailure {
            runCatching {
                context.registerReceiver(screenReceiver, filter)
                isReceiverRegistered = true
            }
        }
    }

    fun stop() {
        cancelScheduledScreensaver()
        player.removeListener(playerListener)
        if (isReceiverRegistered) {
            runCatching { context.unregisterReceiver(screenReceiver) }
            isReceiverRegistered = false
        }
    }

    private fun onScreenTurnedOff() {
        val settings = context.getSettings()
        val isEnabled = settings.getBoolean(KEY_LOCKSCREEN_SCREENSAVER, true)
        if (!isEnabled) return

        // Only schedule if music is currently playing
        if (!player.isPlaying) return

        val delaySec = settings.getInt(KEY_SCREENSAVER_DELAY_SEC, DEFAULT_DELAY_SEC)
        val delayMs = (delaySec.coerceAtLeast(1) * 1000L)

        screensaverJob?.cancel()
        screensaverJob = scope.launch(Dispatchers.Main) {
            delay(delayMs)

            // Re-verify after 7 seconds: is player still playing?
            if (!player.isPlaying) return@launch

            // Trigger screensaver over lock screen
            displayScreensaver()
        }
    }

    fun cancelScheduledScreensaver() {
        screensaverJob?.cancel()
        screensaverJob = null
    }

    private fun displayScreensaver() {
        // 1. Temporarily acquire wake lock to wake display
        runCatching {
            @Suppress("DEPRECATION")
            val wakeLock = powerManager?.newWakeLock(
                PowerManager.SCREEN_BRIGHT_WAKE_LOCK or PowerManager.ACQUIRE_CAUSES_WAKEUP,
                "Nightly:LockScreensaverWakeLock"
            )
            wakeLock?.acquire(4000L)
        }

        // 2. Prepare Intent
        val activityIntent = Intent(context, ScreensaverActivity::class.java).apply {
            addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_SINGLE_TOP or
                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            )
        }

        // 3. Fire Full Screen Intent Notification (Guarantees launch over lockscreen on Android 10..14)
        val pendingIntent = PendingIntent.getActivity(
            context,
            NOTIFICATION_ID,
            activityIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0)
        )

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_mono)
            .setContentTitle("Nightly Screensaver")
            .setContentText("Ambient Soundstage Active")
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setCategory(NotificationCompat.CATEGORY_TRANSPORT)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setFullScreenIntent(pendingIntent, true)
            .setAutoCancel(true)
            .build()

        notificationManager?.notify(NOTIFICATION_ID, notification)

        // 4. Also call startActivity directly
        runCatching {
            context.startActivity(activityIntent)
        }

        // 5. Dismiss full screen notification after slight delay once activity is launched
        scope.launch(Dispatchers.Main) {
            delay(1500L)
            notificationManager?.cancel(NOTIFICATION_ID)
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Ambient Screensaver",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Displays the ambient screensaver when music plays while locked"
                lockscreenVisibility = android.app.Notification.VISIBILITY_PUBLIC
                setSound(null, null)
                enableVibration(false)
            }
            notificationManager?.createNotificationChannel(channel)
        }
    }
}
