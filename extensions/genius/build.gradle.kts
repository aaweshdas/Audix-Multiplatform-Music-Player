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
    archiveBaseName.set("genius")
    archiveClassifier.set("")
    archiveVersion.set("")

    manifest {
        attributes(
            "Extension-Id" to "genius_lyrics",
            "Extension-Name" to "Genius Lyrics",
            "Extension-Class" to "dev.brahmkshatriya.echo.extension.GeniusExtension",
            "Extension-Type" to "LYRICS",
            "Extension-Version-Name" to "1.0.0",
            "Extension-Description" to "Comprehensive song lyrics, liner notes, and track annotations from Genius.",
            "Extension-Author" to "Audix"
        )
    }
}
