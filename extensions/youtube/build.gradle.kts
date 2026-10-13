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
    archiveBaseName.set("youtube")
    archiveClassifier.set("")
    archiveVersion.set("")

    manifest {
        attributes(
            "Extension-Id" to "youtube_music",
            "Extension-Name" to "YouTube Music",
            "Extension-Class" to "dev.brahmkshatriya.echo.extension.YoutubeExtension",
            "Extension-Type" to "MUSIC",
            "Extension-Version-Name" to "1.0.0",
            "Extension-Description" to "Stream millions of songs and official tracks from YouTube Music with adaptive bitrates.",
            "Extension-Author" to "Audix"
        )
    }
}
