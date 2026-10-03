package dev.brahmkshatriya.echo.core.security

/**
 * SecurePrefs - Encrypted key-value storage wrapper for sensitive data (tokens, cookies, auth credentials).
 * Protects sensitive session tokens from being stored in plaintext SharedPreferences or unencrypted files.
 */
interface SecurePrefs {
    fun getString(key: String, defaultValue: String? = null): String?
    fun putString(key: String, value: String?)
    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean
    fun putBoolean(key: String, value: Boolean)
    fun remove(key: String)
    fun clear()

    companion object {
        const val SECURE_PREFS_NAME = "echo_secure_prefs"
    }
}

/**
 * In-memory fallback / cross-platform implementation of SecurePrefs.
 */
class InMemorySecurePrefs : SecurePrefs {
    private val store = mutableMapOf<String, Any>()

    @Synchronized
    override fun getString(key: String, defaultValue: String?): String? {
        return store[key] as? String ?: defaultValue
    }

    @Synchronized
    override fun putString(key: String, value: String?) {
        if (value == null) {
            store.remove(key)
        } else {
            store[key] = value
        }
    }

    @Synchronized
    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return store[key] as? Boolean ?: defaultValue
    }

    @Synchronized
    override fun putBoolean(key: String, value: Boolean) {
        store[key] = value
    }

    @Synchronized
    override fun remove(key: String) {
        store.remove(key)
    }

    @Synchronized
    override fun clear() {
        store.clear()
    }
}
