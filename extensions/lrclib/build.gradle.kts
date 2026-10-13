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
    archiveBaseName.set("lrclib")
    archiveClassifier.set("")
    archiveVersion.set("")

    manifest {
        attributes(
            "Extension-Id" to "lrclib_lyrics",
            "Extension-Name" to "LRCLIB Lyrics",
            "Extension-Class" to "dev.brahmkshatriya.echo.extension.LrclibExtension",
            "Extension-Type" to "LYRICS",
            "Extension-Version-Name" to "1.0.0",
            "Extension-Description" to "Real-time synchronized and plain lyrics for Now Playing tracks.",
            "Extension-Author" to "Audix"
        )
    }
}
