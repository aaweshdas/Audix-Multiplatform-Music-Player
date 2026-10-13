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
    archiveBaseName.set("soundcloud")
    archiveClassifier.set("")
    archiveVersion.set("")

    manifest {
        attributes(
            "Extension-Id" to "soundcloud",
            "Extension-Name" to "SoundCloud",
            "Extension-Class" to "dev.brahmkshatriya.echo.extension.SoundcloudExtension",
            "Extension-Type" to "MUSIC",
            "Extension-Version-Name" to "1.0.0",
            "Extension-Description" to "Stream trending tracks, independent artists, podcasts, and remixes from SoundCloud.",
            "Extension-Author" to "Audix"
        )
    }
}
