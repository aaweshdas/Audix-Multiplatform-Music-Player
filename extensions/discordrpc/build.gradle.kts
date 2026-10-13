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
    archiveBaseName.set("discordrpc")
    archiveClassifier.set("")
    archiveVersion.set("")

    manifest {
        attributes(
            "Extension-Id" to "discord_rpc",
            "Extension-Name" to "Discord Rich Presence",
            "Extension-Class" to "dev.brahmkshatriya.echo.extension.DiscordRpcExtension",
            "Extension-Type" to "TRACKER",
            "Extension-Version-Name" to "1.0.0",
            "Extension-Description" to "Display your Now Playing song, album art, and playback progress in your Discord profile.",
            "Extension-Author" to "Audix"
        )
    }
}
