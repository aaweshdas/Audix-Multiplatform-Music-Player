plugins {
    kotlin("jvm")
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    compileOnly(project(":common"))
    compileOnly(libs.kotlinx.coroutines.core)
    compileOnly(libs.kotlinx.serialization.json)
    compileOnly(libs.okhttp)
}

tasks.jar {
    archiveBaseName.set("spotify")
    archiveClassifier.set("")
    archiveVersion.set("")

    manifest {
        attributes(
            "Extension-Id" to "spotify_music",
            "Extension-Name" to "Spotify",
            "Extension-Class" to "dev.brahmkshatriya.echo.extension.SpotifyExtension",
            "Extension-Type" to "MUSIC",
            "Extension-Version-Name" to "1.0.0",
            "Extension-Description" to "Browse Spotify Top Charts, Today's Top Hits, Viral 50, and stream high-fidelity tracks.",
            "Extension-Author" to "Audix"
        )
    }
}
