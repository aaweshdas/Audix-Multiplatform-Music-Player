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
    archiveBaseName.set("saavn")
    archiveClassifier.set("")
    archiveVersion.set("")

    manifest {
        attributes(
            "Extension-Id" to "saavn_music",
            "Extension-Name" to "JioSaavn",
            "Extension-Class" to "dev.brahmkshatriya.echo.extension.SaavnExtension",
            "Extension-Type" to "MUSIC",
            "Extension-Version-Name" to "1.0.0",
            "Extension-Description" to "Stream millions of Bollywood, English, and Regional hits in crystal-clear 320kbps audio.",
            "Extension-Author" to "Audix"
        )
    }
}
