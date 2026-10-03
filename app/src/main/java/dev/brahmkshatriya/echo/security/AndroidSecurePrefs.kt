package dev.brahmkshatriya.echo.security

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

/**
 * Android implementation of encrypted preferences using Jetpack Security-Crypto (AES256-GCM / MasterKey).
 */
class AndroidSecurePrefs(context: Context) {
    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    val encryptedPrefs: SharedPreferences = EncryptedSharedPreferences.create(
        context,
        "echo_secure_prefs",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun getString(key: String, defaultValue: String? = null): String? {
        return encryptedPrefs.getString(key, defaultValue)
    }

    fun putString(key: String, value: String?) {
        encryptedPrefs.edit().apply {
            if (value == null) remove(key)
            else putString(key, value)
            apply()
        }
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return encryptedPrefs.getBoolean(key, defaultValue)
    }

    fun putBoolean(key: String, value: Boolean) {
        encryptedPrefs.edit().putBoolean(key, value).apply()
    }

    fun remove(key: String) {
        encryptedPrefs.edit().remove(key).apply()
    }

    fun clear() {
        encryptedPrefs.edit().clear().apply()
    }
}
