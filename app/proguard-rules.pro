# Proguard / R8 Keep Rules for Echo-Nightly

# Media3 ExoPlayer
-keep class androidx.media3.exoplayer.** { *; }
-keep class androidx.media3.session.** { *; }
-keep class androidx.media3.common.** { *; }
-keep class androidx.media3.datasource.** { *; }
-keep interface androidx.media3.common.Player { *; }
-keep interface androidx.media3.common.Player$Listener { *; }
-dontwarn androidx.media3.**

# Coil Image Loading
-keep class coil3.** { *; }
-keep class * implements coil3.decode.Decoder$Factory { *; }
-keep class * implements coil3.fetch.Fetcher$Factory { *; }
-dontwarn coil3.**

# Room Database
-keep class androidx.room.** { *; }
-keep class * extends androidx.room.RoomDatabase { *; }
-keep @androidx.room.Entity class * { *; }
-keep @androidx.room.Dao interface * { *; }
-dontwarn androidx.room.**

# SQLDelight
-keep class dev.brahmkshatriya.echo.core.db.** { *; }
-dontwarn app.cash.sqldelight.**

# Kotlin Serialization
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod
-keepclassmembers class * {
    *** Companion;
}
-keepclasseswithmembers class * {
    kotlinx.serialization.KSerializer serializer(...);
}
-keep class dev.brahmkshatriya.echo.common.models.** { *; }
-keep class dev.brahmkshatriya.echo.common.helpers.** { *; }
