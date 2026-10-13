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
    archiveBaseName.set("lastfm")
    archiveClassifier.set("")
    archiveVersion.set("")

    manifest {
        attributes(
            "Extension-Id" to "lastfm_tracker",
            "Extension-Name" to "Last.fm Scrobbler",
            "Extension-Class" to "dev.brahmkshatriya.echo.extension.LastfmExtension",
            "Extension-Type" to "TRACKER",
            "Extension-Version-Name" to "1.0.0",
            "Extension-Description" to "Automatic playback scrobbling and listening history tracking to Last.fm.",
            "Extension-Author" to "Audix"
        )
    }
}
