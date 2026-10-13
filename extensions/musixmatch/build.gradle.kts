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
    archiveBaseName.set("musixmatch")
    archiveClassifier.set("")
    archiveVersion.set("")

    manifest {
        attributes(
            "Extension-Id" to "musixmatch_lyrics",
            "Extension-Name" to "Musixmatch Lyrics",
            "Extension-Class" to "dev.brahmkshatriya.echo.extension.MusixmatchExtension",
            "Extension-Type" to "LYRICS",
            "Extension-Version-Name" to "1.0.0",
            "Extension-Description" to "Time-synced lyrics with line-by-line scrolling synchronization for Now Playing songs.",
            "Extension-Author" to "Audix"
        )
    }
}
