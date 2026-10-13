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
    archiveBaseName.set("radiobrowser")
    archiveClassifier.set("")
    archiveVersion.set("")

    manifest {
        attributes(
            "Extension-Id" to "radio_browser",
            "Extension-Name" to "Radio Browser",
            "Extension-Class" to "dev.brahmkshatriya.echo.extension.RadioBrowserExtension",
            "Extension-Type" to "MUSIC",
            "Extension-Version-Name" to "1.0.0",
            "Extension-Description" to "Free live radio stations, music channels, genres, and top hits worldwide.",
            "Extension-Author" to "Audix"
        )
    }
}
