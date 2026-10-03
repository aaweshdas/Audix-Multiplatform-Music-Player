package dev.brahmkshatriya.echo.common.config

/**
 * Centralized branding configuration for dual-flavor support (Echo / Audix).
 */
object FlavorConfig {
    const val FLAVOR_NAME = "Audix"
    const val LEGACY_FLAVOR_NAME = "Echo"
    const val APP_AUTHOR = "$FLAVOR_NAME Community"
    const val DESKTOP_APP_NAME = "$FLAVOR_NAME Desktop"
    const val GITHUB_REPO = "aaweshdas/Audix-Multiplatform-Music-Player"
    const val GITHUB_URL = "https://github.com/$GITHUB_REPO"
    const val LATEST_VERSION = "v1.0.0"
    const val DEFAULT_EXTENSIONS_URL = "https://raw.githubusercontent.com/itsmechinmoy/echo-extensions/main/echo_extensions.json"
}
